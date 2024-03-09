package com.app.compartz.service;

import com.app.compartz.dto.cart.CartItemDto;

import java.util.List;

public interface CartService {
    List<CartItemDto> getCartItems(Long userId);
}
