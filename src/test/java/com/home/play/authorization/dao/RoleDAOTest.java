package com.home.play.authorization.dao;

import static org.assertj.core.api.Assertions.assertThat;

import javax.transaction.Transactional;

import com.home.play.authorization.dao.RoleDAO;
import com.home.play.authorization.entity.Role;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Transactional
@SpringBootTest
public class RoleDAOTest {

    @Autowired
    RoleDAO roleDAO;

    @Test
    void testSaveRole() {
        int oldSize = getRoleListSize();

        Role role = new Role("tesztgdísgsíg");
        roleDAO.save(role);

        int newSize = getRoleListSize();

        assertThat(oldSize + 1).isEqualTo(newSize);
    }

    private int getRoleListSize() {
        return roleDAO.findAll().size();
    }
}
