package com.app.compartz.service.impl;

import com.app.compartz.component.security.TokenProvider;
import com.app.compartz.domain.user.converter.UserConverter;
import com.app.compartz.domain.user.converter.UserDtoConverter;
import com.app.compartz.domain.user.repository.UserRepository;
import com.app.compartz.dto.user.LoginRequest;
import com.app.compartz.dto.user.UserDto;
import com.app.compartz.dto.user.UserSaveRequest;
import com.app.compartz.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final UserRepository userRepository;
    private final TokenProvider tokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public UserDto getUser(Long id) {
        return userRepository.findById(id)
                .map(UserDtoConverter::new)
                .map(UserDtoConverter::convert)
                .orElseThrow(() -> new UsernameNotFoundException("no such user"));
    }

    @Override
    @Transactional
    public UserDto login(LoginRequest request) {
        var accessToken = this.generateToken(request.getMail(), request.getPassword());

        return userRepository.findByMail(request.getMail())
                .map(user -> new UserDtoConverter(user).convertForLogin(accessToken))
                .orElseThrow(() -> new UsernameNotFoundException("no such user"));
    }

    @Override
    @Transactional
    public UserDto signup(UserSaveRequest request) {
        var user = new UserConverter(request)
                .convert()
                .changePassword(passwordEncoder.encode(request.getPassword()));
        System.out.println(user.getPassword());
        var entity = userRepository.save(user);
        var accessToken = this.generateToken(request.getMail(), request.getPassword());

        return new UserDtoConverter(entity).convertForLogin(accessToken);
    }

    private String generateToken(String mail, String password) {
        // 1. Login ID/PW 를 기반으로 AuthenticationToken 생성
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(mail, password);

        // 2. 실제로 검증 (사용자 비밀번호 체크) 이 이루어지는 부분
        //    authenticate 메서드가 실행이 될 때 CustomUserDetailsService 에서 만들었던 loadUserByUsername 메서드가 실행됨
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        // 3. 인증 정보를 기반으로 JWT 토큰 생성
        return tokenProvider.generateTokenDto(authentication);
    }
}
