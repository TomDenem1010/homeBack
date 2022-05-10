package com.home.play.database.role.entity;

import javax.persistence.*;

@Entity
@Table(name="role")
public class RoleEntity {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    private String name;

    public RoleEntity(String name) {
        this.name = name;
    }
    
    public RoleEntity() {
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


}
