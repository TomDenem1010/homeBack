package com.home.play.database.accesstoken.dao;

import javax.persistence.EntityManager;

import com.home.play.database.accesstoken.entity.AccessTokenEntity;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AccessTokenDao {
    
    private final EntityManager entityManager;

    public AccessTokenDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void save(AccessTokenEntity token) {
        entityManager.persist(token);
    }
}
