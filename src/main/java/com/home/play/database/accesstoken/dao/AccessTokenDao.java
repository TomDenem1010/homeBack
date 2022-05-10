package com.home.play.database.accesstoken.dao;

import java.util.List;

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

    public List<AccessTokenEntity> findAll() {
        return entityManager.createQuery("select t from AccessTokenEntity t", AccessTokenEntity.class).getResultList();
    }

    public List<AccessTokenEntity> findBySecret(String secret) {
        return entityManager.createQuery(
            "select t from AccessTokenEntity t where " + 
                "t.secret = :secret_param", AccessTokenEntity.class)
                    .setParameter("secret_param", secret)
                    .getResultList();
    }

}
