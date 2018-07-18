package com.infoshare.kodziaki.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "DISTRICTS")
public class District {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotNull
    private String district;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public District() {

    }

    public District(String district) {
        this.district = district;
    }
}
