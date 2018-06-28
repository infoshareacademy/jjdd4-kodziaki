package com.infoshare.kodziaki;

import java.math.BigDecimal;

public class UserPreferencesBuilder {

    private PlaceType placeType;
    private String city;
    private String district;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private BigDecimal minArea;
    private BigDecimal maxArea;
    private Integer rooms;
    private Boolean hasElevator;
    private Boolean smokingAllowed;
    private Boolean animalAllowed;
    private Boolean onlyLongTerm;

    public UserPreferencesBuilder setPlaceType(PlaceType placeType) {
        this.placeType = placeType;
        return this;
    }

    public UserPreferencesBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public UserPreferencesBuilder setDistrict(String district) {
        this.district = district;
        return this;
    }

    public UserPreferencesBuilder setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
        return this;
    }

    public UserPreferencesBuilder setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
        return this;
    }

    public UserPreferencesBuilder setMinArea(BigDecimal minArea) {
        this.minArea = minArea;
        return this;
    }

    public UserPreferencesBuilder setMaxArea(BigDecimal maxArea) {
        this.maxArea = maxArea;
        return this;
    }

    public UserPreferencesBuilder setRooms(Integer rooms) {
        this.rooms = rooms;
        return this;
    }

    public UserPreferencesBuilder setHasElevator(Boolean hasElevator) {
        this.hasElevator = hasElevator;
        return this;
    }

    public UserPreferencesBuilder setSmokingAllowed(Boolean smokingAllowed) {
        this.smokingAllowed = smokingAllowed;
        return this;
    }

    public UserPreferencesBuilder setAnimalAllowed(Boolean animalAllowed) {
        this.animalAllowed = animalAllowed;
        return this;
    }

    public UserPreferencesBuilder setOnlyLongTerm(Boolean onlyLongTerm) {
        this.onlyLongTerm = onlyLongTerm;
        return this;
    }

    public UserPreferences createUserPreferences() {
        return new UserPreferences(
                placeType,
                city,
                district,
                minPrice,
                maxPrice,
                minArea,
                maxArea,
                rooms,
                hasElevator,
                smokingAllowed,
                animalAllowed,
                onlyLongTerm);
    }
}