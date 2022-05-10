package com.home.play.api.login.service;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;

import com.home.play.api.login.helper.LoginRequest;
import com.home.play.api.login.helper.LoginResponse;
import com.home.play.database.accesstoken.dao.AccessTokenDao;
import com.home.play.database.accesstoken.entity.AccessTokenEntity;
import com.home.play.database.user.dao.UserDao;
import com.home.play.database.user.entity.UserEntity;

import org.springframework.stereotype.Component;

@Component
public class LoginService {

    private UserDao userDao;
    private AccessTokenDao accessTokenDao;

    public LoginService(UserDao userDao, AccessTokenDao accessTokenDao) {
        this.userDao = userDao;
        this.accessTokenDao = accessTokenDao;
    }

    public LoginResponse login(LoginRequest loginRequest) {
        try {
            return logic(loginRequest);
        } catch(RuntimeException exception) {
            throw exception;
        }
    }

    private LoginResponse logic(LoginRequest loginRequest) {
        Optional<UserEntity> user = findUser(loginRequest);

        if(user.isPresent()) {
            createAccessTokenToUser(user.get());
            return createSuccessResponse(user.get());
        } else {
            return createFailResponse();
        }
    }

    private Optional<UserEntity> findUser(LoginRequest loginRequest) {
        return userDao.findByNameAndPassword(loginRequest.getName(), loginRequest.getPassword());
    }

    private void createAccessTokenToUser(UserEntity user) {
        AccessTokenEntity accessToken = 
            new AccessTokenEntity(
                Timestamp.valueOf(ZonedDateTime.now(ZoneId.of("Europe/Budapest")).toLocalDateTime()), 
                Timestamp.valueOf(ZonedDateTime.now(ZoneId.of("Europe/Budapest")).plusMinutes(5).toLocalDateTime()));
        accessTokenDao.save(accessToken);
        user.setAccessToken(accessToken);
    }

    private LoginResponse createSuccessResponse(UserEntity user) {
        return LoginResponse.Builder.newBuilder()
            .withName(user.getName())
            .withPassword(user.getPassword())
            .withStart(user.getAccessToken().getStart())
            .withEnd(user.getAccessToken().getEnd())
                .build();
    }

    private LoginResponse createFailResponse() {
        return LoginResponse.Builder.newBuilder()
            .withMessage("Nono")
                .build();
    }
}
