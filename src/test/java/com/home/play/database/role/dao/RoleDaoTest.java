package com.home.play.database.role.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

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
        int oldSize = getRoleListSize();
        RoleEntity role = new RoleEntity(NAME);

        roleDAO.save(role);

        int newSize = getRoleListSize();
        List<RoleEntity> roles = roleDAO.findByName(NAME);

        assertThat(oldSize + 1).isEqualTo(newSize);
        assertThat(roles).isNotEmpty();
    }

    private int getRoleListSize() {
        return roleDAO.findAll().size();
    }
}
