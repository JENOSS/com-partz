package com.app.compartz.service.impl;

import com.app.compartz.domain.cart.converter.CartItemDtoConverter;
import com.app.compartz.domain.cart.repository.CartItemRepository;
import com.app.compartz.dto.cart.CartItemDto;
import com.app.compartz.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartItemRepository cartItemRepository;

    @Override
    public List<CartItemDto> getCartItems(Long userId) {
        return cartItemRepository.findAllByUserIdOrderByIdDesc(userId).stream()
                .map(CartItemDtoConverter::new)
                .map(CartItemDtoConverter::convert)
                .toList();
    }
}
