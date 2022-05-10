package com.home.play.database.accesstoken.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

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
    private static final String SECRET = "TesztAccessTokenSecret";
    @Autowired
    AccessTokenDao accessTokenDAO;

    @Test
    void testSave() {
        int oldSize = getTokenListSize();

        accessTokenDAO.save(new AccessTokenEntity(START_TIME, END_TIME, SECRET));

        int newSize = getTokenListSize();
        List<AccessTokenEntity> accessTokens = accessTokenDAO.findBySecret(SECRET);

        assertThat(oldSize + 1).isEqualTo(newSize);
        assertThat(accessTokens.get(0).getStart()).isEqualTo(START_TIME);
        assertThat(accessTokens.get(0).getEnd()).isEqualTo(END_TIME);
    }

    private int getTokenListSize() {
        return accessTokenDAO.findAll().size();
    }
}
