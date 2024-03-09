package com.app.compartz.domain.order.converter;

import com.app.compartz.domain.order.model.OrderDetail;
import com.app.compartz.domain.product.model.Product;
import com.app.compartz.dto.order.OrderSaveDto;
import lombok.RequiredArgsConstructor;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Function;

@RequiredArgsConstructor
public class OrderDetailConverter {
    private final OrderSaveDto origin;
    private final Product product;

    public OrderDetail convert() {
        return OrderDetail.builder()
                .count(origin.getCount())
                .product(product)
                .build();
    }
}
