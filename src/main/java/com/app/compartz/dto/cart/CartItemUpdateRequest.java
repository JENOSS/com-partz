package com.app.compartz.dto.cart;

import lombok.Getter;

@Getter
public class CartItemUpdateRequest {
    private Long userId;
    private Long cartItemId;
    private Integer count;
}
