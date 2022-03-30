package com.home.play.authorization;

import javax.persistence.*;

import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    private String name;

    public Role(String name) {
        this.name = name;
    }
    
    public Role() {
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
