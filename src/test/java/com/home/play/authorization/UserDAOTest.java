package com.home.play.authorization;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Transactional
@SpringBootTest
public class UserDAOTest {

    @Autowired
    UserDAO userDAO;

    @Test
    void testSave() {
        int oldSize = getUserListSize();

        Role role = new Role("admin3");
        User user = new User("TRD3", "admin3", List.of(role));
        userDAO.save(user);

        int newSize = getUserListSize();

        assertThat(oldSize + 1).isEqualTo(newSize);
    }

    private int getUserListSize() {
        return userDAO.findAll().size();
    }
}
