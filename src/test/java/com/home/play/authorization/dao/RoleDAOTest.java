package com.home.play.authorization.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.transaction.Transactional;

import com.home.play.authorization.entity.Role;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Transactional
@SpringBootTest
public class RoleDAOTest {

    private static final String NAME = "TesztRoleName";
    @Autowired
    RoleDAO roleDAO;

    @Test
    void testSaveRole() {
        int oldSize = getRoleListSize();
        Role role = new Role(NAME);

        roleDAO.save(role);

        int newSize = getRoleListSize();
        List<Role> roles = roleDAO.findByName(NAME);

        assertThat(oldSize + 1).isEqualTo(newSize);
        assertThat(roles).isNotEmpty();
    }

    private int getRoleListSize() {
        return roleDAO.findAll().size();
    }
}
