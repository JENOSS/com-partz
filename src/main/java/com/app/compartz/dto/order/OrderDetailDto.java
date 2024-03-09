package com.app.compartz.dto.order;

import com.app.compartz.dto.product.ProductDto;
import lombok.Builder;

public record OrderDetailDto(Long id,
                             Integer count,
                             ProductDto product) {

    @Builder
    public OrderDetailDto {

    }
}
