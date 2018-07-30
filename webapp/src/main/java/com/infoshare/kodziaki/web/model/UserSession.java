package com.infoshare.kodziaki.web.model;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@SessionScoped
public class UserSession implements Serializable {

    private boolean logged;
    private String name;
    private String email;
    private boolean admin;

    public UserSession() {
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}