package com.home.play.api.helper;

import java.util.List;

public class MenuResponse {
    
    private final List<MenuDto> menuDtos;

    public MenuResponse(List<MenuDto> menuDtos) {
        this.menuDtos = menuDtos;
    }

    public List<MenuDto> getMenuDtos() {
        return menuDtos;
    }

}
