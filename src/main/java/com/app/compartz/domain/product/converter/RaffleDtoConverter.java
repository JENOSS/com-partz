package com.app.compartz.domain.product.converter;

import com.app.compartz.domain.product.model.Raffle;
import com.app.compartz.dto.product.RaffleDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RaffleDtoConverter {
    private final Raffle origin;

    public RaffleDto convert() {
        return RaffleDto.builder()
                .id(origin.getId())
                .product(new ProductDtoConverter(origin.getProduct()).convert())
                .build();
    }

}
