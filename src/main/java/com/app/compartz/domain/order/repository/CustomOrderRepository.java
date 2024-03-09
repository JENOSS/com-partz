package com.app.compartz.domain.order.repository;

import com.app.compartz.domain.order.model.Order;
import com.app.compartz.dto.order.OrderDto;
import com.app.compartz.dto.order.OrderRequest;
import org.springframework.data.domain.Page;

public interface CustomOrderRepository {
    Page<OrderDto> findPageBySearch(OrderRequest request);
}
