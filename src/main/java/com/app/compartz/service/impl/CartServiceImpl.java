package com.app.compartz.service.impl;

import com.app.compartz.domain.cart.converter.CartItemDtoConverter;
import com.app.compartz.domain.cart.model.CartItem;
import com.app.compartz.domain.cart.repository.CartItemRepository;
import com.app.compartz.domain.product.repository.ProductRepository;
import com.app.compartz.dto.cart.CartItemDto;
import com.app.compartz.dto.cart.CartItemSaveRequest;
import com.app.compartz.dto.cart.CartItemUpdateRequest;
import com.app.compartz.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;

    @Override
    public List<CartItemDto> getCartItems(Long userId) {
        return cartItemRepository.findAllByUserIdOrderByIdDesc(userId).stream()
                .map(CartItemDtoConverter::new)
                .map(CartItemDtoConverter::convert)
                .toList();
    }

    @Override
    public CartItemDto save(CartItemSaveRequest request) {
        var product = productRepository.findById((request.getProductId()))
                .orElseThrow(() -> new NoSuchElementException("no items"));
        var cartItem = CartItem.builder()
                .userId(request.getUserId())
                .count(request.getCount())
                .product(product)
                .build();
        return new CartItemDtoConverter(cartItemRepository.save(cartItem)).convert();
    }

    @Override
    public CartItemDto update(CartItemUpdateRequest request) {
        var cartItem = cartItemRepository.findById(request.getCartItemId())
                .orElseThrow(() -> new NoSuchElementException("no items"));
        cartItem.changeCount(request.getCount());
        return new CartItemDtoConverter(cartItemRepository.save(cartItem)).convert();
    }

    @Override
    public void delete(Long cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }
}
