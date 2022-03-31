package com.home.play.authorization.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String password;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Role> role;

    public User(String name, String password, List<Role> role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public User() {
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

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }

    
}
