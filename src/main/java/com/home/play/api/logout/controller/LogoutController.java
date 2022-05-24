package com.home.play.api.logout.controller;

import com.home.play.api.logout.helper.LogoutRequest;
import com.home.play.api.logout.service.LogoutService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogoutController {
    
    private LogoutService logoutService;

    public LogoutController(LogoutService logoutService) {
        this.logoutService = logoutService;
    }
    
    @PostMapping("/api/logout")
    public void getMenu(@RequestBody LogoutRequest loginRequest) {
        logoutService.logout(loginRequest);
    } 
}
