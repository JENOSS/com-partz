package com.app.compartz.domain.order.converter;

import com.app.compartz.domain.order.model.Order;
import com.app.compartz.dto.order.OrderDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderDtoConverter {
    private final Order origin;

    public OrderDto convert() {
        var details = origin.getDetails().stream()
                .map(OrderDetailDtoConverter::new)
                .map(OrderDetailDtoConverter::convert)
                .toList();
        return OrderDto.builder()
                .id(origin.getId())
                .amount(origin.getAmount())
                .details(details)
                .createdDatetime(origin.getCreatedDatetime())
                .userId(origin.getUserId())
                .build();
    }
}
