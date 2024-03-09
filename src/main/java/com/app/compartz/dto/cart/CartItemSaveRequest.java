package com.app.compartz.dto.cart;

import lombok.Getter;

@Getter
public class CartItemSaveRequest {
    private Long userId;
    private Long productId;
    private Integer count;
}
