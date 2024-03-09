package com.app.compartz.domain.cart.repository;

import com.app.compartz.domain.cart.model.CartItem;
import com.app.compartz.dto.cart.CartItemDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findAllByUserIdOrderByIdDesc(Long userId);
}
