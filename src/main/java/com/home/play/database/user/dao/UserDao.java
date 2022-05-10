package com.home.play.database.user.dao;

import java.util.Optional;

import javax.persistence.EntityManager;

import com.home.play.database.user.entity.UserEntity;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Component
public class UserDao {

    private final EntityManager entityManager;

    public UserDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void save(UserEntity user) {
        entityManager.persist(user);
    }

    public Optional<UserEntity> findByNameAndPassword(String name, String password) {
        return entityManager.createQuery(
            "select u from UserEntity u where " + 
                "u.name = :name_param and " +
                "u.password = :password_param", UserEntity.class)
                    .setParameter("name_param", name)
                    .setParameter("password_param", password)
                    .getResultStream()
                    .findFirst();
    }
}
