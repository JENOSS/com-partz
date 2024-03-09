package com.app.compartz.domain.order.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
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

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> details;

    @Builder
    public Order(Long id, Integer amount, LocalDateTime createdDatetime, List<OrderDetail> details) {
        this.id = id;
        this.amount = amount;
        this.createdDatetime = createdDatetime;
        this.details = details;
    }
}
