package com.infoshare.kodziaki.web.model;

import com.infoshare.kodziaki.Place;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "users")
public class User<Set> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "name")
    private String name = "";

    @Column(name = "email")
    private String email = "";

    @Column (name = "isAdmin")
    private boolean isAdmin = false;

    public User() {
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

}
