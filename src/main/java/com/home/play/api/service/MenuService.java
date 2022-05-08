package com.home.play.api.service;

import java.util.ArrayList;
import java.util.List;

import com.home.play.api.helper.MenuDto;
import com.home.play.api.helper.MenuResponse;
import com.home.play.database.MenuDao;
import com.home.play.database.MenuEntity;

import org.springframework.stereotype.Component;

@Component
public class MenuService {

    private MenuDao menuDao;
    
    public MenuService(MenuDao menuDao) {
        this.menuDao = menuDao;
    }

    public MenuResponse leker() {
        return valasszaAlakit(lekerAdatbazisbol());
    }

    private List<MenuEntity> lekerAdatbazisbol() {
        return menuDao.findAll();
    }

    private MenuResponse valasszaAlakit(List<MenuEntity> menuEntities) {
        List<MenuDto> menuDtos = new ArrayList<>();
        
        for (int i = 0; i < menuEntities.size(); i++) {
            menuDtos.add(MenuDto.Builder.newBuilder()
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
