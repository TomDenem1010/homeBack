package com.home.play.authorization;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Component
public class RoleDAO{
    
    private final EntityManager entityManager;

    public RoleDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Role role) {
        entityManager.persist(role);
    }
}