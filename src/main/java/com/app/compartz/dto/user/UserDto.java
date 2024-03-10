package com.app.compartz.dto.user;

import lombok.Builder;

public record UserDto(Long id,
                      String mail,
                      String name,
                      String nickName,
                      String phone,
                      String accessToken) {

    @Builder
    public UserDto {

    }
}
