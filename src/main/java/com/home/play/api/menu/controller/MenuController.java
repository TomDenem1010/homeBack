package com.home.play.api.menu.controller;

import com.home.play.api.menu.helper.MenuResponse;
import com.home.play.api.menu.service.MenuService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {
    
    private MenuService menuService;
    
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/api/menu")
    public MenuResponse getMenu() {
        return menuService.getMenu();
    } 
}
