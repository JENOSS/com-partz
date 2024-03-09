package com.app.compartz.controller;

import com.app.compartz.dto.cart.CartItemDto;
import com.app.compartz.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/carts")
public class CartController {
    private final CartService cartService;

    @GetMapping
    public ResponseEntity<List<CartItemDto>> getCarts(Long userId) {
        return ResponseEntity.ok(cartService.getCartItems(userId));
    }
}
