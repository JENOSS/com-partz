package com.app.compartz.domain.order.converter;

import com.app.compartz.domain.order.model.Order;
import com.app.compartz.domain.order.model.OrderDetail;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.reducing;

@RequiredArgsConstructor
public class OrderConverter {
    private final Long userId;

    public Order convert() {

        return Order.builder()
                .createdDatetime(LocalDateTime.now())
                .userId(userId)
                .build();
    }
}
