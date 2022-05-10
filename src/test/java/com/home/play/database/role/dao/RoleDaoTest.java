package com.home.play.database.role.dao;

import static org.assertj.core.api.Assertions.assertThat;

import javax.transaction.Transactional;

import com.home.play.database.role.entity.RoleEntity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Transactional
@SpringBootTest
public class RoleDaoTest {

    private static final String NAME = "TesztRoleName";
    @Autowired
    RoleDao roleDAO;

    @Test
    void testSaveRole() {
        RoleEntity role = new RoleEntity(NAME);
        roleDAO.save(role);

        assertThat(role.getId()).isNotNull();
        assertThat(role.getName()).isEqualTo(NAME);
    }
}
