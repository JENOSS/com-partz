package com.app.compartz.dto.user;

import lombok.Getter;

@Getter
public class UserSaveRequest {
    private String name;
    private String mail;
    private String nickName;
    private String phone;
    private String password;
}
