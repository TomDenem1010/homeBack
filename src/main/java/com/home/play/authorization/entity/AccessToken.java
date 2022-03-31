package com.home.play.authorization.entity;

import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name="access_token")
public class AccessToken {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private Timestamp start;

    private Timestamp end;

    private String secret;

    public AccessToken(Timestamp start, Timestamp end, String secret) {
        this.start = start;
        this.end = end;
        this.secret = secret;
    }

    public AccessToken() {
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

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

}
