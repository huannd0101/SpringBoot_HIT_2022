package com.hit.buoi3.models;

import java.util.List;

public class Res {
    private String message;
    List<User> users;


    public Res(String message, List<User> users) {
        this.message = message;
        this.users = users;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
