package com.app.compartz.domain.order.model;

import com.app.compartz.domain.product.model.Product;
import javax.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer count;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Builder
    public OrderDetail(Long id, Integer count, Product product, Order order) {
        this.id = id;
        this.count = count;
        this.product = product;
        this.order = order;
    }
}
