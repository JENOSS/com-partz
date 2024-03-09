package com.app.compartz.dto.product;

import lombok.Builder;

public record CategoryDto(Long id,
                          String name,
                          Integer sortOrder) {

    @Builder
    public CategoryDto {

    }
}
