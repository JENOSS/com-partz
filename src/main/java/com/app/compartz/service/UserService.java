package com.app.compartz.service;

import com.app.compartz.dto.user.LoginRequest;
import com.app.compartz.dto.user.UserDto;
import com.app.compartz.dto.user.UserSaveRequest;

public interface UserService {
    UserDto getUser(Long id);

    UserDto login(LoginRequest request);

    UserDto signup(UserSaveRequest request);
}
