package com.app.compartz.domain.product.model;


import javax.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String image;
    private Integer price;
    private String descriptionImage;
    private LocalDateTime createdDatetime;
    private Long categoryId;

    @Builder
    public Product(Long id, String name, String image, Integer price, String descriptionImage, Long categoryId, LocalDateTime createdDatetime) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.descriptionImage = descriptionImage;
        this.categoryId = categoryId;
        this.createdDatetime = createdDatetime;
    }
}
