package com.app.compartz.dto.product;

import com.app.compartz.domain.product.model.SortType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductRequest {
    private Long categoryId;
    private String sortType;
    private Integer page;
    private Integer size;

    @Builder
    public ProductRequest(Long categoryId, String sortType, Integer page, Integer size) {
        this.categoryId = categoryId;
        this.sortType = Objects.requireNonNullElse(sortType, SortType.ID_DESC.name());
        this.page = Objects.requireNonNullElse(page, 0);
        this.size = Objects.requireNonNullElse(size, 10);
    }
}
