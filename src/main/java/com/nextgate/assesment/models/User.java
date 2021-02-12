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

    private String username;

    private String password;

    // Constructors

    /**
     * Default constructor
     * 
     */
    protected User() {}

    /**
     * Primary constructor
     * 
     * @param username the user's username
     * @param password the user's password
     */
    public User (String username, String password){
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format(
            "Customer[id=%d, username='%s']",
            id, username);
    }

    // Getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}