package com.home.play.authorization;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserDAOTest {

    @Autowired
    UserDAO userDAO;

    @Test
    void testSave() {
        Role role = new Role("admin3");
        User user = new User("TRD3", "admin3", List.of(role));
        userDAO.save(user);
    }
}
