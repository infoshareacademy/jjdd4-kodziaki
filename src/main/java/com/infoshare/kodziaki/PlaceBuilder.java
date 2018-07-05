package com.infoshare.kodziaki;

import java.math.BigDecimal;

public class PlaceBuilder {
    private int id;
    private String title;
    private PlaceType placeType;
    private BigDecimal price;
    private double area;
    private int rooms;
    private int floor;
    private String district;
    private String city;
    private boolean hasElevator;
    private boolean smokingAllowed;
    private boolean animalAllowed;
    private boolean onlyLongTerm;
    private String description;
    private String author;
    private String phoneNumber;

    public PlaceBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public PlaceBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public PlaceBuilder setPlaceType(PlaceType placeType) {
        this.placeType = placeType;
        return this;
    }

    public PlaceBuilder setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public PlaceBuilder setArea(double area) {
        this.area = area;
        return this;
    }

    public PlaceBuilder setRooms(int rooms) {
        this.rooms = rooms;
        return this;
    }

    public PlaceBuilder setFloor(int floor) {
        this.floor = floor;
        return this;
    }

    public PlaceBuilder setDistrict(String district) {
        this.district = district;
        return this;
    }

    public PlaceBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public PlaceBuilder setHasElevator(boolean hasElevator) {
        this.hasElevator = hasElevator;
        return this;
    }

    public PlaceBuilder setSmokingAllowed(boolean smokingAllowed) {
        this.smokingAllowed = smokingAllowed;
        return this;
    }

    public PlaceBuilder setAnimalAllowed(boolean animalAllowed) {
        this.animalAllowed = animalAllowed;
        return this;
    }

    public PlaceBuilder setOnlyLongTerm(boolean onlyLongTerm) {
        this.onlyLongTerm = onlyLongTerm;
        return this;
    }

    public PlaceBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public PlaceBuilder setAuthor(String author) {
        this.author = author;
        return this;
    }

    public PlaceBuilder setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Place createPlace() {
        return new Place(id,
                title,
                placeType,
                price,
                area,
                rooms,
                floor,
                district,
                city,
                hasElevator,
                smokingAllowed,
                animalAllowed,
                onlyLongTerm,
                description,
                author,
                phoneNumber);
    }
}