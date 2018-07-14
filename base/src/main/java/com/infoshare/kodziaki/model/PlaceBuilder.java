package com.infoshare.kodziaki.model;

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

    public PlaceBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public PlaceBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public PlaceBuilder withPlaceType(PlaceType placeType) {
        this.placeType = placeType;
        return this;
    }

    public PlaceBuilder withPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public PlaceBuilder withArea(double area) {
        this.area = area;
        return this;
    }

    public PlaceBuilder withRooms(int rooms) {
        this.rooms = rooms;
        return this;
    }

    public PlaceBuilder withFloor(int floor) {
        this.floor = floor;
        return this;
    }

    public PlaceBuilder withDistrict(String district) {
        this.district = district;
        return this;
    }

    public PlaceBuilder withCity(String city) {
        this.city = city;
        return this;
    }

    public PlaceBuilder withHasElevator(boolean hasElevator) {
        this.hasElevator = hasElevator;
        return this;
    }

    public PlaceBuilder withSmokingAllowed(boolean smokingAllowed) {
        this.smokingAllowed = smokingAllowed;
        return this;
    }

    public PlaceBuilder withAnimalAllowed(boolean animalAllowed) {
        this.animalAllowed = animalAllowed;
        return this;
    }

    public PlaceBuilder withOnlyLongTerm(boolean onlyLongTerm) {
        this.onlyLongTerm = onlyLongTerm;
        return this;
    }

    public PlaceBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public PlaceBuilder withAuthor(String author) {
        this.author = author;
        return this;
    }

    public PlaceBuilder withPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Place buildPlace() {
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