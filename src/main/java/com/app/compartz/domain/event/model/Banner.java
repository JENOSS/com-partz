package com.app.compartz.domain.event.model;

import javax.persistence.*;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Banner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String image;

    @Builder
    public Banner(Long id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }
}
