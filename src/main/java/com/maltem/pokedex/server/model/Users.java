package com.maltem.pokedex.server.model;

import java.io.Serializable;
import java.util.List;

public class Users implements Serializable {
    private List<User> users;

    public Users() {}

    public List<User> getTowns() {
        return users;
    }

    public void setTowns(List<User> towns) {
        this.users = towns;
    }

    @Override
    public String toString() {
        return "Users: " + users.toString();
    }
}