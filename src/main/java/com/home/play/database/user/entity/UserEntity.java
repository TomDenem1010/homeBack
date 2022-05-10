package com.home.play.database.user.entity;

import java.util.List;

import javax.persistence.*;

import com.home.play.database.accesstoken.entity.AccessTokenEntity;
import com.home.play.database.role.entity.RoleEntity;

@Entity
@Table(name="user")
public class UserEntity {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String password;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<RoleEntity> role;

    @OneToOne(cascade = CascadeType.PERSIST)
    private AccessTokenEntity accessToken;

    public UserEntity(String name, String password, List<RoleEntity> role, AccessTokenEntity accessToken) {
        this.name = name;
        this.password = password;
        this.role = role;
        this.accessToken = accessToken;
    }

    public UserEntity() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<RoleEntity> getRole() {
        return role;
    }

    public void setRole(List<RoleEntity> role) {
        this.role = role;
    }

    public AccessTokenEntity getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(AccessTokenEntity accessToken) {
        this.accessToken = accessToken;
    }

    
}
