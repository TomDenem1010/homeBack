package com.home.play.authorization.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.home.play.authorization.entity.AccessToken;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AccessTokenDAO {
    
    private final EntityManager entityManager;

    public AccessTokenDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void save(AccessToken token) {
        entityManager.persist(token);
    }

    public List<AccessToken> findAll() {
        return entityManager.createQuery("select t from AccessToken t", AccessToken.class).getResultList();
    }

    public List<AccessToken> findBySecret(String secret) {
        return entityManager.createQuery(
            "select t from AccessToken t where " + 
                "t.secret = :secret_param", AccessToken.class)
                    .setParameter("secret_param", secret)
                    .getResultList();
    }

}
