package com.app.compartz.domain.order.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer amount;
    private LocalDateTime createdDatetime;
    private Long userId;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    @OrderBy("id desc")
    private List<OrderDetail> details;

    @Builder
    public Order(Long id, LocalDateTime createdDatetime,  Long userId) {
        this.id = id;
        this.createdDatetime = createdDatetime;
        this.userId = userId;
    }

    public void addDetails(OrderDetail orderDetail) {
        if (details == null) details = new ArrayList<>();
        orderDetail.setOrder(this);

        this.details.add(orderDetail);
        this.amount = (this.amount != null ? this.amount : 0)  + (orderDetail.getProduct().getPrice() * orderDetail.getCount());
    }

}
