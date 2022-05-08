package com.home.play.database;

import javax.persistence.*;

@Entity
@Table(name="menu")
public class MenuEntity {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="name_to_display")
    private String name;

    @Column(name="path_to_move")
    private String pathTo;
    
    @Column(name="order_to_display")
    private int order;

    public MenuEntity() {
    }

    public MenuEntity(String name, String pathTo, int order) {
        this.name = name;
        this.pathTo = pathTo;
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

    public String getPathTo() {
        return pathTo;
    }

    public void setPathTo(String pathTo) {
        this.pathTo = pathTo;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

}
