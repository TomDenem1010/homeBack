package com.home.play.authorization.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import com.home.play.authorization.entity.Role;
import com.home.play.authorization.entity.Token;
import com.home.play.authorization.entity.User;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Transactional
@SpringBootTest
public class TokenDAOTest {
    
    @Autowired
    TokenDAO tokenDAO;

    @Test
    void testSave() {
        int oldSize = getTokenListSize();

        tokenDAO.save(new Token(Timestamp.valueOf(LocalDateTime.now()), Timestamp.valueOf(LocalDateTime.now().plusMinutes(5))));

        int newSize = getTokenListSize();

        assertThat(oldSize + 1).isEqualTo(newSize);
    }

    private int getTokenListSize() {
        return tokenDAO.findAll().size();
    }
}
