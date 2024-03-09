package com.app.compartz.dto.cart;

import com.app.compartz.dto.product.ProductDto;
import lombok.Builder;

public record CartItemDto(Long id,
                          Integer count,
                          ProductDto product){

    @Builder
    public CartItemDto {

    }
}
