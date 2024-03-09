package com.app.compartz.domain.product.converter;

import com.app.compartz.domain.product.model.Category;
import com.app.compartz.dto.product.CategoryDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CategoryDtoConverter {
    private final Category origin;

    public CategoryDto convert() {
        return CategoryDto.builder()
                .id(origin.getId())
                .name(origin.getName())
                .sortOrder(origin.getSortOrder())
                .build();
    }
}
