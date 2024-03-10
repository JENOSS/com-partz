package com.app.compartz.service.impl;

import com.app.compartz.component.exception.CustomException;
import com.app.compartz.domain.cart.converter.CartItemDtoConverter;
import com.app.compartz.domain.cart.model.CartItem;
import com.app.compartz.domain.cart.repository.CartItemRepository;
import com.app.compartz.domain.product.repository.ProductRepository;
import com.app.compartz.dto.cart.CartItemDto;
import com.app.compartz.dto.cart.CartItemSaveRequest;
import com.app.compartz.dto.cart.CartItemUpdateRequest;
import com.app.compartz.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;

    @Override
    @Transactional(readOnly = true)
    public List<CartItemDto> getCartItems(Long userId) {
        return cartItemRepository.findAllByUserIdOrderByIdDesc(userId).stream()
                .map(CartItemDtoConverter::new)
                .map(CartItemDtoConverter::convert)
                .toList();
    }

    @Override
    @Transactional
    public CartItemDto save(CartItemSaveRequest request) {
        if (Objects.isNull(request.getUserId())) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "유저 id를 입력해주세요");
        }

        if (Objects.isNull(request.getProductId())) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "상품 id를 입력해주세요");
        }

        if (Objects.isNull(request.getCount())) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "개수를 입력해주세요");
        }

        var product = productRepository.findById((request.getProductId()))
                .orElseThrow(() -> new CustomException(HttpStatus.BAD_REQUEST, "상품이 존재하지 않습니다. id : " + request.getProductId()));
        var cartItem = CartItem.builder()
                .userId(request.getUserId())
                .count(request.getCount())
                .product(product)
                .build();
        return new CartItemDtoConverter(cartItemRepository.save(cartItem)).convert();
    }

    @Override
    @Transactional
    public CartItemDto update(CartItemUpdateRequest request) {


        var cartItem = cartItemRepository.findById(request.getCartItemId())
                .orElseThrow(() -> new CustomException(HttpStatus.BAD_REQUEST, "유효하지 않은 CartItemId 입니다.id : " + request.getCartItemId()));
        cartItem.changeCount(request.getCount());
        return new CartItemDtoConverter(cartItemRepository.save(cartItem)).convert();
    }

    @Override
    @Transactional
    public void delete(Long cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }
}
