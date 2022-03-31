package com.home.play.authorization.entity;

import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name="token")
public class Token {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private Timestamp fromTime;

    private Timestamp toTime;

    public Token(Timestamp from, Timestamp to) {
        this.fromTime = from;
        this.toTime = to;
    }

    public Long getId() {
        return id;
    }

    public Timestamp getFrom() {
        return fromTime;
    }

    public void setFrom(Timestamp from) {
        this.fromTime = from;
    }

    public Timestamp getTo() {
        return toTime;
    }

    public void setTo(Timestamp to) {
        this.toTime = to;
    }

}
