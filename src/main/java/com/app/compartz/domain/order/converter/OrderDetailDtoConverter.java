package com.app.compartz.domain.order.converter;

import com.app.compartz.domain.order.model.OrderDetail;
import com.app.compartz.domain.product.converter.ProductDtoConverter;
import com.app.compartz.dto.order.OrderDetailDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderDetailDtoConverter {
    private final OrderDetail origin;

    public OrderDetailDto convert() {
        return OrderDetailDto.builder()
                .id(origin.getId())
                .count(origin.getCount())
                .product(new ProductDtoConverter(origin.getProduct()).convert())
                .build();
    }
}
