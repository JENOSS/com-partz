package com.app.compartz.domain.order.repository.impl;

import com.app.compartz.domain.order.converter.OrderDetailDtoConverter;
import com.app.compartz.domain.order.converter.OrderDtoConverter;
import com.app.compartz.domain.order.model.Order;
import com.app.compartz.domain.order.repository.CustomOrderRepository;
import com.app.compartz.dto.order.OrderDetailDto;
import com.app.compartz.dto.order.OrderDto;
import com.app.compartz.dto.order.OrderRequest;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import static com.app.compartz.domain.order.model.QOrder.order;
import static com.app.compartz.domain.order.model.QOrderDetail.orderDetail;
import static com.app.compartz.domain.product.model.QProduct.product;

@Repository
public class CustomOrderRepositoryImpl implements CustomOrderRepository {
    private final JPAQueryFactory queryFactory;

    public CustomOrderRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public Page<OrderDto> findPageBySearch(OrderRequest request) {
        var pageRequest = PageRequest.of(request.getPage(), request.getSize());
        var result = queryFactory
                .from(order)
                .where(order.userId.eq(request.getUserId()))
                .orderBy(order.id.desc())
                .fetchResults();
        return new PageImpl<>(result.getResults(), pageRequest, result.getTotal())
                .map(order -> new OrderDtoConverter(((Order) order)).convert());
    }
}
