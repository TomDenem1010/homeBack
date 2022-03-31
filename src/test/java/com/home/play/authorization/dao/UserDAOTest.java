package com.home.play.authorization.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import com.home.play.authorization.entity.AccessToken;
import com.home.play.authorization.entity.Role;
import com.home.play.authorization.entity.User;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Transactional
@SpringBootTest
public class UserDAOTest {

    private static final String ROLE_NAME = "TesztRoleName";
    private static final Timestamp TOKEN_FROM_TIME = Timestamp.valueOf(LocalDateTime.now());
    private static final Timestamp TOKEN_TO_TIME = Timestamp.valueOf(LocalDateTime.now().plusMinutes(5));
    private static final String TOKEN_SECRET = "TesztAccessTokenSecret";
    private static final String USER_NAME = "TesztUserName";
    private static final String USER_PASSWORD = "TesztUserPassword";
    @Autowired
    UserDAO userDAO;

    @Test
    void testSave() {
        int oldSize = getUserListSize();
        Role role = new Role(ROLE_NAME);
        AccessToken accessToken = new AccessToken(TOKEN_FROM_TIME, TOKEN_TO_TIME, TOKEN_SECRET);
        User user = new User(USER_NAME, USER_PASSWORD, List.of(role), accessToken);

        userDAO.save(user);

        int newSize = getUserListSize();
        List<User> users = userDAO.findByNameAndPassword(USER_NAME, USER_PASSWORD);

        assertThat(oldSize + 1).isEqualTo(newSize);
        assertThat(users).isNotEmpty();
    }

    private int getUserListSize() {
        return userDAO.findAll().size();
    }
}
