package com.home.play.database.accesstoken.entity;

import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name="access_token")
public class AccessTokenEntity {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private Timestamp start;

    private Timestamp end;

    public AccessTokenEntity(Timestamp start, Timestamp end) {
        this.start = start;
        this.end = end;
    }

    public AccessTokenEntity() {
    }

    public Long getId() {
        return id;
    }

    public Timestamp getStart() {
        return start;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    public Timestamp getEnd() {
        return end;
    }

    public void setEnd(Timestamp end) {
        this.end = end;
    }
}
