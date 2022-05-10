package com.home.play.database.role.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.home.play.database.role.entity.RoleEntity;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Component
public class RoleDao {
    
    private final EntityManager entityManager;

    public RoleDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void save(RoleEntity role) {
        entityManager.persist(role);
    }

    public List<RoleEntity> findAll() {
        return entityManager.createQuery("select r from RoleEntity r", RoleEntity.class).getResultList();
    }

    public List<RoleEntity> findByName(String name) {
        return entityManager.createQuery("select r from RoleEntity r where r.name = :name_param", RoleEntity.class).setParameter("name_param", name) .getResultList();
    }
}
