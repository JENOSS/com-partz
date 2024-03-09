package com.app.compartz.domain.product.converter;

import com.app.compartz.domain.product.model.Product;
import com.app.compartz.dto.product.ProductDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductDtoConverter {
    private final Product origin;

    public ProductDto convert() {
        return ProductDto.builder()
                .id(origin.getId())
                .name(origin.getName())
                .price(origin.getPrice())
                .image(origin.getImage())
                .descriptionImage(origin.getDescriptionImage())
                .createdDatetime(origin.getCreatedDatetime())
                .build();
    }
}
