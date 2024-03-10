package com.app.compartz.controller;

import com.app.compartz.dto.user.LoginRequest;
import com.app.compartz.dto.user.UserDto;
import com.app.compartz.dto.user.UserSaveRequest;
import com.app.compartz.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(userService.login(request));
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDto> signup(@RequestBody UserSaveRequest request) {
        return ResponseEntity.ok(userService.signup(request));
    }
}
