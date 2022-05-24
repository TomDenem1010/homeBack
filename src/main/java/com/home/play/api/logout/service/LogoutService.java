package com.home.play.api.logout.service;

import java.util.Optional;

import com.home.play.api.logout.helper.LogoutRequest;
import com.home.play.database.user.dao.UserDao;
import com.home.play.database.user.entity.UserEntity;

import org.springframework.stereotype.Component;

@Component
public class LogoutService {
    
    private UserDao userDao;

    public LogoutService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void logout(LogoutRequest logoutRequest) {
        try {
            logic(logoutRequest);
        } catch(RuntimeException exception) {
            throw exception;
        }
    }

    private void logic(LogoutRequest logoutRequest) {
        Optional<UserEntity> user = findUser(logoutRequest);

        if(user.isPresent()) {
            clearAccessTokenInUser(user.get());
        }
    }

    private Optional<UserEntity> findUser(LogoutRequest logoutRequest) {
        return userDao.findByNameAndPassword(logoutRequest.getName(), logoutRequest.getPassword());
    }

    private void clearAccessTokenInUser(UserEntity user) {
        user.setAccessToken(null);
        userDao.save(user);
    }
}
