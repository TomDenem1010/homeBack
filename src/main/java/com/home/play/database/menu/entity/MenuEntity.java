package com.home.play.database.menu.entity;

import javax.persistence.*;

@Entity
@Table(name="menu")
public class MenuEntity {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="name_to_display")
    private String name;

    @Column(name="path_to_link")
    private String path;
    
    @Column(name="order_to_display")
    private int order;

    public MenuEntity() {
    }

    public MenuEntity(String name, String path, int order) {
        this.name = name;
        this.path = path;
        this.order = order;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

}
