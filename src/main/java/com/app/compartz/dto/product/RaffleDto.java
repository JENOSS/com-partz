package com.app.compartz.dto.product;

import lombok.Builder;

public record RaffleDto(Long id,
                        ProductDto product) {

    @Builder
    public RaffleDto {

    }
}
