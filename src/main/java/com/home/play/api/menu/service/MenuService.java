package com.home.play.api.menu.service;

import java.util.ArrayList;
import java.util.List;

import com.home.play.api.menu.helper.MenuResponseDto;
import com.home.play.api.menu.helper.MenuResponse;
import com.home.play.database.menu.dao.MenuDao;
import com.home.play.database.menu.entity.MenuEntity;

import org.springframework.stereotype.Component;

@Component
public class MenuService {

    private MenuDao menuDao;
    
    public MenuService(MenuDao menuDao) {
        this.menuDao = menuDao;
    }

    public MenuResponse getMenu() {
        return valasszaAlakit(lekerAdatbazisbol());
    }

    private List<MenuEntity> lekerAdatbazisbol() {
        return menuDao.findAll();
    }

    private MenuResponse valasszaAlakit(List<MenuEntity> menuEntities) {
        List<MenuResponseDto> menuDtos = new ArrayList<>();
        
        for (int i = 0; i < menuEntities.size(); i++) {
            menuDtos.add(MenuResponseDto.Builder.newBuilder()
                .withId(menuEntities.get(i).getId())
                .withName(menuEntities.get(i).getName())
                .withPath(menuEntities.get(i).getPathTo())
                .withOrder(menuEntities.get(i).getOrder())
                .build()
            );
        }

        return new MenuResponse(menuDtos);
    }
}
