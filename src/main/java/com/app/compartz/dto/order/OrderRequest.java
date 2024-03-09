package com.app.compartz.dto.order;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderRequest {
    private Long userId;
    private Integer page;
    private Integer size;

    @Builder
    public OrderRequest(Long userId, Integer page, Integer size) {
        this.userId = userId;
        this.page = Objects.requireNonNullElse(page, 0);
        this.size = Objects.requireNonNullElse(size, 10);
    }
}
