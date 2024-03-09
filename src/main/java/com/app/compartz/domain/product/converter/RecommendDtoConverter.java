package com.app.compartz.domain.product.converter;

import com.app.compartz.domain.product.model.Recommend;
import com.app.compartz.dto.product.RecommendDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RecommendDtoConverter {
    private final Recommend origin;

    public RecommendDto convert() {
        return RecommendDto.builder()
                .id(origin.getId())
                .product(new ProductDtoConverter(origin.getProduct()).convert())
                .build();
    }
}
