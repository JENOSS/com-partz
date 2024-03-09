package com.app.compartz.domain.cart.converter;

import com.app.compartz.domain.cart.model.CartItem;
import com.app.compartz.domain.product.converter.ProductDtoConverter;
import com.app.compartz.dto.cart.CartItemDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CartItemDtoConverter {
    private final CartItem origin;

    public CartItemDto convert() {
        var product = new ProductDtoConverter(origin.getProduct()).convert();
        return CartItemDto.builder()
                .id(origin.getId())
                .count(origin.getCount())
                .product(product)
                .build();
    }
}
