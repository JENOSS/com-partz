package com.app.compartz.controller;

import com.app.compartz.dto.cart.CartItemDto;
import com.app.compartz.dto.cart.CartItemSaveRequest;
import com.app.compartz.dto.cart.CartItemUpdateRequest;
import com.app.compartz.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<CartItemDto> save(@RequestBody CartItemSaveRequest request) {
        return ResponseEntity.ok(cartService.save(request));
    }

    @PutMapping
    public ResponseEntity<CartItemDto> update(@RequestBody CartItemUpdateRequest request) {
        return ResponseEntity.ok(cartService.update(request));
    }

    @DeleteMapping
    public ResponseEntity<?> delete(Long cartItemId) {
        cartService.delete(cartItemId);
        return ResponseEntity.noContent().build();
    }
}
