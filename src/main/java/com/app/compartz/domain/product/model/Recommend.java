package com.app.compartz.domain.product.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Recommend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime createdDatetime;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Builder
    public Recommend(Long id, LocalDateTime createdDatetime, Product product) {
        this.id = id;
        this.createdDatetime = createdDatetime;
        this.product = product;
    }
}
