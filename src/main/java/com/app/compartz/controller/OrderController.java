package com.app.compartz.controller;

import com.app.compartz.dto.order.OrderDto;
import com.app.compartz.dto.order.OrderRequest;
import com.app.compartz.dto.order.OrderSaveRequest;
import com.app.compartz.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<Page<OrderDto>> getOrders(OrderRequest request) {
        return ResponseEntity.ok(orderService.getOrders(request));
    }

    @PostMapping
    public ResponseEntity<OrderDto> save(@RequestBody OrderSaveRequest request) {
        return ResponseEntity.ok(orderService.save(request));
    }
}
