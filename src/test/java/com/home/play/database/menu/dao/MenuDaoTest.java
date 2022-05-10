package com.home.play.database.menu.dao;

import static org.assertj.core.api.Assertions.assertThat;

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
        MenuEntity menuEntity = new MenuEntity(NAME, PATH, ORDER);
        menuDao.save(menuEntity);

        assertThat(menuEntity.getId()).isNotNull();
        assertThat(menuEntity.getName()).isEqualTo(NAME);
        assertThat(menuEntity.getPath()).isEqualTo(PATH);
        assertThat(menuEntity.getOrder()).isEqualTo(ORDER);
    }
}
