package com.app.compartz.domain.cart.model;

import com.app.compartz.domain.product.model.Product;
import javax.persistence.*;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer count;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Builder
    public CartItem(Long id, Integer count, Product product) {
        this.id = id;
        this.count = count;
        this.product = product;
    }
}
