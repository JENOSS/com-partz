package com.app.compartz.service.impl;

import com.app.compartz.domain.order.repository.OrderRepository;
import com.app.compartz.dto.order.OrderDto;
import com.app.compartz.dto.order.OrderRequest;
import com.app.compartz.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<OrderDto> getOrders(OrderRequest request) {
        return orderRepository.findPageBySearch(request);
    }
}
