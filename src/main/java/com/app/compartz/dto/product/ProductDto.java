package com.app.compartz.dto.product;

import lombok.Builder;

import java.time.LocalDateTime;

public record ProductDto(Long id,
                         String name,
                         String image,
                         Integer price,
                         String description,
                         String descriptionImage,
                         LocalDateTime createdDatetime){

    @Builder
    public ProductDto {

    }
}
