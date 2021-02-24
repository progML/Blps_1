package com.lab.controller;

import com.lab.config.jwt.JwtProvider;
import com.lab.entity.UserEntity;
import com.lab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.Valid;

@RestController
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String registerUser(@RequestBody @Valid RegistrationRequest registrationRequest) {
        UserEntity u = new UserEntity();
        u.setPassword(registrationRequest.getPassword());
        u.setLogin(registrationRequest.getLogin());
        userService.saveUser(u);
        return "OK";
    }

    @PostMapping(value = "/auth",  consumes = MediaType.APPLICATION_JSON_VALUE)
    public AuthResponse auth(@RequestBody AuthRequest request) {
        UserEntity userEntity = userService.findByLoginAndPassword(request.getLogin(), request.getPassword());
        String token = jwtProvider.generateToken(userEntity.getLogin());
        return new AuthResponse(token);
    }
}
