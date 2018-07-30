package com.infoshare.kodziaki.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "LOCATIONS")
public class Location {

    @Id
    @Column(name = "id")
    @NotNull
    private long id;

    @Column(name = "district")
    @NotNull
    private String district;

    @Column(name = "city")
    @NotNull
    private String city;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Location() {

    }

    public Location(long id, String district, String city) {
        this.id = id;
        this.district = district;
        this.city = city;
    }
}
