package com.home.play.authorization.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.home.play.authorization.entity.Role;

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

    public List<Role> findAll() {
        return entityManager.createQuery("select r from Role r", Role.class).getResultList();
    }

    public List<Role> findByName(String name) {
        return entityManager.createQuery("select r from Role r where r.name = :name_param", Role.class).setParameter("name_param", name) .getResultList();
    }
}
