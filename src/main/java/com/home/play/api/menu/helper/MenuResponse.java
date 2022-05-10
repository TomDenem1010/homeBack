package com.home.play.api.menu.helper;

import java.util.List;

public class MenuResponse {
    
    private final List<MenuResponseDto> menuDtos;

    public MenuResponse(List<MenuResponseDto> menuDtos) {
        this.menuDtos = menuDtos;
    }

    public List<MenuResponseDto> getMenuDtos() {
        return menuDtos;
    }

}
