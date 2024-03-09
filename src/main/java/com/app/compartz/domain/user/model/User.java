package com.app.compartz.domain.user.model;

import javax.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mail;
    private String name;
    private String nickName;
    private String phone;
    private String password;

    @Builder
    public User(Long id, String mail, String name, String nickName, String phone, String password) {
        this.id = id;
        this.mail = mail;
        this.name = name;
        this.nickName = nickName;
        this.phone = phone;
        this.password = password;
    }
}
