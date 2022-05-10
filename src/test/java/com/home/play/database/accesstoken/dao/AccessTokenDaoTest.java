package com.home.play.database.accesstoken.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.transaction.Transactional;

import com.home.play.database.accesstoken.entity.AccessTokenEntity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Transactional
@SpringBootTest
public class AccessTokenDaoTest {
    
    private static final Timestamp START_TIME = Timestamp.valueOf(LocalDateTime.now());
    private static final Timestamp END_TIME = Timestamp.valueOf(LocalDateTime.now().plusMinutes(5));

    @Autowired
    AccessTokenDao accessTokenDao;

    @Test
    void testSave() {
        AccessTokenEntity accessToken = new AccessTokenEntity(START_TIME, END_TIME);
        accessTokenDao.save(accessToken);

        assertThat(accessToken.getId()).isNotNull();
        assertThat(accessToken.getStart()).isEqualTo(START_TIME);
        assertThat(accessToken.getEnd()).isEqualTo(END_TIME);
    }
}
