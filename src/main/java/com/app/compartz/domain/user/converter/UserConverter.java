package com.app.compartz.domain.user.converter;

import com.app.compartz.domain.user.model.User;
import com.app.compartz.dto.user.UserSaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class UserConverter {
    private final UserSaveRequest origin;

    public User convert() {
        return User.builder()
                .mail(origin.getMail())
                .name(origin.getName())
                .nickName(origin.getNickName())
                .phone(origin.getPhone())
                .build();
    }
}
