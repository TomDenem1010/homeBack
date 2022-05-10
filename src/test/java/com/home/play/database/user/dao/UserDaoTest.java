package com.home.play.database.user.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import com.home.play.database.accesstoken.dao.AccessTokenDao;
import com.home.play.database.accesstoken.entity.AccessTokenEntity;
import com.home.play.database.role.dao.RoleDao;
import com.home.play.database.role.entity.RoleEntity;
import com.home.play.database.user.entity.UserEntity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Transactional
@SpringBootTest
public class UserDaoTest {

    private static final String ROLE_NAME = "TesztRoleName";
    private static final Timestamp TOKEN_START_TIME = Timestamp.valueOf(LocalDateTime.now());
    private static final Timestamp TOKEN_END_TIME = Timestamp.valueOf(LocalDateTime.now().plusMinutes(5));
    private static final String USER_NAME = "TesztUserName";
    private static final String USER_PASSWORD = "TesztUserPassword";

    @Autowired
    UserDao userDao;

    @Autowired
    RoleDao roleDao;

    @Autowired
    AccessTokenDao accessTokenDao;

    @Test
    void testSave() {
        RoleEntity role = new RoleEntity(ROLE_NAME);
        roleDao.save(role);

        AccessTokenEntity accessToken = new AccessTokenEntity(TOKEN_START_TIME, TOKEN_END_TIME);
        accessTokenDao.save(accessToken);

        UserEntity user = new UserEntity(USER_NAME, USER_PASSWORD, List.of(role), accessToken);
        userDao.save(user);

        assertThat(user.getId()).isNotNull();
        assertThat(user.getName()).isEqualTo(USER_NAME);
        assertThat(user.getPassword()).isEqualTo(USER_PASSWORD);

        assertThat(user.getAccessToken().getId()).isNotNull();
        assertThat(user.getAccessToken().getStart()).isEqualTo(TOKEN_START_TIME);
        assertThat(user.getAccessToken().getEnd()).isEqualTo(TOKEN_END_TIME);

        assertThat(user.getRole().size()).isEqualTo(1);
        assertThat(user.getRole().get(0).getId()).isNotNull();
        assertThat(user.getRole().get(0).getName()).isEqualTo(ROLE_NAME);
    }
}
