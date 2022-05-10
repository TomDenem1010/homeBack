package com.home.play.database.menu.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.home.play.database.menu.entity.MenuEntity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Transactional
@SpringBootTest
public class MenuDaoTest {
    
    private static final String NAME = "NAME";
    private static final String PATH = "PATH";
    private static final int ORDER = 000;

    @Autowired
    MenuDao menuDao;

    @Test
    void testSaveMenu() {
        MenuEntity menuEntity = new MenuEntity();

        menuEntity.setName(NAME);
        menuEntity.setPathTo(PATH);
        menuEntity.setOrder(ORDER);

        menuDao.save(menuEntity);

        long id = menuEntity.getId();

        assertSaveIsOk(id);
    }

    private void assertSaveIsOk(long id) {
        List<MenuEntity> menuEntities = menuDao.findAll();

        List<MenuEntity> menuEntity = menuEntities
            .stream()
            .filter(menu -> menu.getId() == id)
            .collect(Collectors.toList());

        assertThat(menuEntity.size()).isEqualTo(1);
        assertThat(menuEntity.get(0).getName()).isEqualTo(NAME);
        assertThat(menuEntity.get(0).getPathTo()).isEqualTo(PATH);
        assertThat(menuEntity.get(0).getOrder()).isEqualTo(ORDER);
    }

}
