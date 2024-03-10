package com.app.compartz.domain.user.converter;

import com.app.compartz.domain.user.model.User;
import com.app.compartz.dto.user.UserDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserDtoConverter {
    private final User origin;

    public UserDto convert() {
        return UserDto.builder()
                .id(origin.getId())
                .mail(origin.getMail())
                .name(origin.getName())
                .nickName(origin.getNickName())
                .phone(origin.getPhone())
                .build();
    }

    public UserDto convertForLogin(String accessToken) {
        return UserDto.builder()
                .id(origin.getId())
                .mail(origin.getMail())
                .name(origin.getName())
                .nickName(origin.getNickName())
                .phone(origin.getPhone())
                .accessToken(accessToken)
                .build();
    }
}
