package com.home.play.authorization.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.home.play.authorization.entity.Token;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TokenDAO {
    
    private final EntityManager entityManager;

    public TokenDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Token token) {
        entityManager.persist(token);
    }

    public List<Token> findAll() {
        return entityManager.createQuery("select t from Token t", Token.class).getResultList();
    }

}
