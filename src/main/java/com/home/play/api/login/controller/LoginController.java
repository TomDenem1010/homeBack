package com.home.play.api.login.controller;

import com.home.play.api.login.helper.LoginRequest;
import com.home.play.api.login.helper.LoginResponse;
import com.home.play.api.login.service.LoginService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    
    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }
    
    @PostMapping("/api/login")
    public LoginResponse getMenu(@RequestBody LoginRequest loginRequest) {
        return loginService.login(loginRequest);
    } 
}
