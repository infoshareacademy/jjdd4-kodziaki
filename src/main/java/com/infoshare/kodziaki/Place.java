package com.infoshare.kodziaki;

import java.math.BigDecimal;
import com.infoshare.kodziaki.PlaceType;

public class Place {

    private int id;
    private PlaceType placeType;

    private BigDecimal price;
    private double area;
    private int rooms;
    private int floor;

    private String district;
    private String city;

    private String description;
    private String title;

    private boolean hasElevator;
    private boolean smokingAllowed;
    private boolean animalAllowed;
    private boolean onlyLongTerm;

    private String author;
    private String phoneNumber;


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