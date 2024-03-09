package com.app.compartz.service;

import com.app.compartz.dto.cart.CartItemDto;
import com.app.compartz.dto.cart.CartItemSaveRequest;
import com.app.compartz.dto.cart.CartItemUpdateRequest;

import java.util.List;

public interface CartService {
    List<CartItemDto> getCartItems(Long userId);

    CartItemDto save(CartItemSaveRequest request);

    CartItemDto update(CartItemUpdateRequest request);

    void delete(Long cartItemId);
}
