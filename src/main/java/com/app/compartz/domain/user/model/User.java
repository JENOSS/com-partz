package com.app.compartz.domain.user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mail;
    private String name;
    private String nickName;
    private String phone;

    @Builder
    public User(Long id, String mail, String name, String nickName, String phone) {
        this.id = id;
        this.mail = mail;
        this.name = name;
        this.nickName = nickName;
        this.phone = phone;
    }

    public User changeMail(String mail) {
        this.mail = mail;
        return this;
    }

    public User changeName(String name) {
        this.name = name;
        return this;
    }

    public User changeNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public User changePhone(String phone) {
        this.phone = phone;
        return this;
    }
}
