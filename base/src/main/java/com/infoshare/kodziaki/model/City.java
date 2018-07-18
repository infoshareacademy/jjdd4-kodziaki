package com.infoshare.kodziaki.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CITIES")
public class City {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @NotNull
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City() {

    }

    public City(String name) {
        this.name = name;
    }
}
