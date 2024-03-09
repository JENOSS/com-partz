package com.app.compartz.dto.order;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

public record OrderDto(Long id,
                       Integer amount,
                       LocalDateTime createdDatetime,
                       Long userId,
                       List<OrderDetailDto> details) {

    @Builder
    public OrderDto {

    }
}
