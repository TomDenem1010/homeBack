package com.home.play.database;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.transaction.Transactional;

import com.home.play.database.menu.dao.MenuDao;
import com.home.play.database.menu.entity.MenuEntity;
import com.home.play.database.role.dao.RoleDao;
import com.home.play.database.role.entity.RoleEntity;
import com.home.play.database.user.dao.UserDao;
import com.home.play.database.user.entity.UserEntity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//Temporary solution
@Transactional
@SpringBootTest
public class Flayway {
    
    @Autowired
    RoleDao roleDao;

    @Autowired
    UserDao userDao;

    @Autowired
    MenuDao menuDao;
    
    @Test
    void setUpTemporaryDb() {
        createRoles();
        createAdminUser();
        createMenu();

        assertThat(1).isNotNull();
    }

    private void createRoles() {
        RoleEntity roleToWatch = new RoleEntity("Watcher");
        roleDao.save(roleToWatch);

        RoleEntity roleToCreate = new RoleEntity("Creater");
        roleDao.save(roleToCreate);

        RoleEntity roleToModify = new RoleEntity("Modifier");
        roleDao.save(roleToModify);

        RoleEntity roleToDelete = new RoleEntity("Deleter");
        roleDao.save(roleToDelete);
    }

    private void createAdminUser() {
        List<RoleEntity> roles = roleDao.findAll();
        UserEntity adminUser = new UserEntity("admin", "admin", roles, null);
        userDao.save(adminUser);
    }

    private void createMenu() {
        MenuEntity videoMenu = new MenuEntity("Video", "video", 100);
        menuDao.save(videoMenu);

        MenuEntity magicMenu = new MenuEntity("Magic", "magic", 200);
        menuDao.save(magicMenu);
    }
}
