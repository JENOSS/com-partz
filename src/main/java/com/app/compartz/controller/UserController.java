package com.app.compartz.controller;

import com.app.compartz.dto.user.UserDto;
import com.app.compartz.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(userService.getUser(id));
    }
}
