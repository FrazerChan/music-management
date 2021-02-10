package com.nextgate.assesment.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="native")
    private Integer id;

    private String user;

    private String pass;

    // Constructors

    protected User() {}

    public User (String user, String pass){
        this.user = user;
        this.pass = pass;
    }

    @Override
    public String toString() {
        return String.format(
            "Customer[id=%d, user='%s']",
            id, user);
    }

    // Getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}