package com.app.compartz.service;

import com.app.compartz.dto.order.OrderDto;
import com.app.compartz.dto.order.OrderRequest;
import com.app.compartz.dto.order.OrderSaveRequest;
import com.app.compartz.dto.product.ProductDto;
import org.springframework.data.domain.Page;

public interface OrderService {
    Page<OrderDto> getOrders(OrderRequest request);

    OrderDto save(OrderSaveRequest request);
}
