package com.infoshare.kodziaki.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "ADVERTISMENTS")
public class Place {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "placeType")
    @NotNull
    private PlaceType placeType;

    @Column(name = "price")
    @NotNull
    private BigDecimal price;

    @Column(name = "area")
    @NotNull
    private double area;

    @Column(name = "rooms")
    @NotNull
    private int rooms;

    @Column(name = "floor")
    @NotNull
    private int floor;

    @Column(name = "district")
    @NotNull
    private String district;

    @Column(name = "city")
    @NotNull
    private String city;

    @Column(name = "description", length = 2048)
    @NotNull
    private String description;

    @Column(name = "title")
    @NotNull
    private String title;

    @Column(name = "hasElevator")
    @NotNull
    private boolean hasElevator;

    @Column(name = "smokingAllowed")
    @NotNull
    private boolean smokingAllowed;

    @Column(name = "animalAllowed")
    @NotNull
    private boolean animalAllowed;

    @Column(name = "onlyLongTerm")
    @NotNull
    private boolean onlyLongTerm;

    @Column(name = "author")
    @NotNull
    private String author;

    @Column(name = "phoneNumber")
    @NotNull
    private String phoneNumber;

    public Place() {

    }

    public Place(int id,
                 String title,
                 PlaceType placeType,
                 BigDecimal price,
                 double area,
                 int rooms,
                 int floor,
                 String district,
                 String city,
                 boolean hasElevator,
                 boolean smokingAllowed,
                 boolean animalAllowed,
                 boolean onlyLongTerm,
                 String description,
                 String author,
                 String phoneNumber) {
        this.id = id;
        this.title = title;
        this.placeType = placeType;
        this.price = price;
        this.area = area;
        this.rooms = rooms;
        this.floor = floor;
        this.district = district;
        this.city = city;
        this.hasElevator = hasElevator;
        this.smokingAllowed = smokingAllowed;
        this.animalAllowed = animalAllowed;
        this.onlyLongTerm = onlyLongTerm;
        this.description = description;
        this.author = author;
        this.phoneNumber = phoneNumber;
    }

    public int getId() { return id; }

    public PlaceType getPlaceType() { return placeType; }

    public BigDecimal getPrice() { return price; }

    public double getArea() { return area; }

    public int getRooms() { return rooms; }

    public int getFloor() { return floor; }

    public String getDistrict() { return district; }

    public String getCity() { return city; }

    public String getDescription() { return description; }

    public String getTitle() { return title; }

    public boolean isHasElevator() { return hasElevator; }

    public boolean isSmokingAllowed() { return smokingAllowed; }

    public boolean isAnimalAllowed() { return animalAllowed; }

    public boolean isOnlyLongTerm() { return onlyLongTerm; }

    public String getAuthor() { return author; }

    public String getPhoneNumber() { return phoneNumber; }

}