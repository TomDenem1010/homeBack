package com.home.play.authorization.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.home.play.authorization.entity.User;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Component
public class UserDAO {

    private final EntityManager entityManager;

    public UserDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void save(User user) {
        entityManager.persist(user);
    }

    public List<User> findAll() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    public List<User> findByNameAndPassword(String name, String password) {
        return entityManager.createQuery(
            "select u from User u where " + 
                "u.name = :name_param and " +
                "u.password = :password_param", User.class)
                    .setParameter("name_param", name)
                    .setParameter("password_param", password)
                    .getResultList();
    }
}
