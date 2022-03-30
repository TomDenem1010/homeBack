package com.home.play.authorization;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RoleDAOTest {

    @Autowired
    RoleDAO roleDAO;

    @Test
    void testSaveRole() {
        Role role = new Role("teszt");
        roleDAO.save(role);
    }
}
