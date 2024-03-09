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
    private Long userId;

    @OneToMany(mappedBy = "order")
    @OrderBy("id desc")
    private List<OrderDetail> details;

    @Builder
    public Order(Long id, Integer amount, LocalDateTime createdDatetime, List<OrderDetail> details, Long userId) {
        this.id = id;
        this.amount = amount;
        this.createdDatetime = createdDatetime;
        this.details = details;
        this.userId = userId;
    }
}
