package com.home.play.database;

import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class MenuDao {
    
    private final EntityManager entityManager;

    public MenuDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void save(MenuEntity menuEntity) {
        entityManager.persist(menuEntity);
    }
    
    public List<MenuEntity> findAll() {
        return entityManager.createQuery("select m from MenuEntity m", MenuEntity.class).getResultList();
    }
}
