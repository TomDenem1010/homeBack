package com.home.play.database.user.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import com.home.play.database.accesstoken.entity.AccessTokenEntity;
import com.home.play.database.role.entity.RoleEntity;
import com.home.play.database.user.entity.UserEntity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Transactional
@SpringBootTest
public class UserDaoTest {

    private static final String ROLE_NAME = "TesztRoleName";
    private static final Timestamp TOKEN_FROM_TIME = Timestamp.valueOf(LocalDateTime.now());
    private static final Timestamp TOKEN_TO_TIME = Timestamp.valueOf(LocalDateTime.now().plusMinutes(5));
    private static final String TOKEN_SECRET = "TesztAccessTokenSecret";
    private static final String USER_NAME = "TesztUserName";
    private static final String USER_PASSWORD = "TesztUserPassword";
    @Autowired
    UserDao userDao;

    @Test
    void testSave() {
        int oldSize = getUserListSize();
        RoleEntity role = new RoleEntity(ROLE_NAME);
        AccessTokenEntity accessToken = new AccessTokenEntity(TOKEN_FROM_TIME, TOKEN_TO_TIME, TOKEN_SECRET);
        UserEntity user = new UserEntity(USER_NAME, USER_PASSWORD, List.of(role), accessToken);

        userDao.save(user);

        int newSize = getUserListSize();
        List<UserEntity> users = userDao.findByNameAndPassword(USER_NAME, USER_PASSWORD);

        assertThat(oldSize + 1).isEqualTo(newSize);
        assertThat(users).isNotEmpty();
    }

    private int getUserListSize() {
        return userDao.findAll().size();
    }
}
