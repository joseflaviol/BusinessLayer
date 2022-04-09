package com.example.businesslayer.models;

import java.io.Serializable;

public class User implements Serializable {

    private String username;
    private String password;
    private String group;

    public User() {
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

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String toJson() {
        return "{\"username\": \"" + this.getUsername() +
                "\", \"password\": \"" + this.getPassword() +
                "\", \"group\": \"" + this.getGroup() +
                "\"}";
    }
}
