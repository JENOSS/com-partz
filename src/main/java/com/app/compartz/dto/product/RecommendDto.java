package com.app.compartz.dto.product;

import lombok.Builder;

public record RecommendDto(Long id,
                           ProductDto product) {

    @Builder
    public RecommendDto {

    }
}
