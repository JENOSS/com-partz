package com.app.compartz.service.impl;

import com.app.compartz.component.exception.CustomException;
import com.app.compartz.domain.cart.repository.CartItemRepository;
import com.app.compartz.domain.order.converter.OrderConverter;
import com.app.compartz.domain.order.converter.OrderDetailConverter;
import com.app.compartz.domain.order.converter.OrderDtoConverter;
import com.app.compartz.domain.order.repository.OrderRepository;
import com.app.compartz.domain.product.repository.ProductRepository;
import com.app.compartz.dto.order.OrderDto;
import com.app.compartz.dto.order.OrderRequest;
import com.app.compartz.dto.order.OrderSaveRequest;
import com.app.compartz.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final CartItemRepository cartItemRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<OrderDto> getOrders(OrderRequest request) {
        return orderRepository.findPageBySearch(request);
    }

    @Override
    @Transactional
    public OrderDto save(OrderSaveRequest request) {
        if (Objects.isNull(request.getUserId())) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "유저 id를 입력해주세요");
        }

        if (Objects.isNull(request.getItems()) || request.getItems().isEmpty()) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "상품이 없습니다.");
        }

        var order = new OrderConverter(request.getUserId()).convert();

        for (var detail : request.getItems()) {
            var product = productRepository.findById((detail.getProductId()))
                    .orElseThrow(() -> new CustomException(HttpStatus.BAD_REQUEST, "존재하지 않는 상품 id 입니다. id : " + detail.getProductId()));
            order.addDetails( new OrderDetailConverter(detail, product).convert());
        }

        if (Objects.nonNull(request.getCartItemIds()) && !request.getCartItemIds().isEmpty()) {
            cartItemRepository.deleteAllById(request.getCartItemIds());
        }

        return new OrderDtoConverter(orderRepository.save(order)).convert();
    }
}
