package com.app.compartz.domain.order;

import com.app.compartz.domain.product.Product;
import jakarta.persistence.*;
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

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
