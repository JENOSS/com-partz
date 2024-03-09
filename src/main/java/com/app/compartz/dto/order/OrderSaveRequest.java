package com.app.compartz.dto.order;

import lombok.Getter;

import java.util.List;

@Getter
public class OrderSaveRequest {
    private Long userId;
    private List<Long> cartItemIds;
    private List<OrderSaveDto> items;
}
