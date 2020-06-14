package com.cov.covproxym.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Code {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id ;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Code() {
    }

    public User getUser() {
        return user;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Integer getKey() {
        return Key;
    }

    public void setKey(Integer key) {
        Key = key;
    }





    private Integer Key ;
    private String date ;
}
