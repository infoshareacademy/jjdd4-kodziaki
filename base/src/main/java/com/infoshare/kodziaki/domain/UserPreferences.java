package com.infoshare.kodziaki.domain;

import java.math.BigDecimal;

public class UserPreferences {

    private PlaceType placeType;
    private String city;
    private String district;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private Double minArea;
    private Double maxArea;
    private Integer minRooms;
    private Integer maxRooms;
    private Integer minFloor;
    private Integer maxFloor;
    private Boolean hasElevator;
    private Boolean smokingAllowed;
    private Boolean animalAllowed;
    private Boolean onlyLongTerm;

    public PlaceType getPlaceType() {
        return placeType;
    }

    public String getCity() {
        return city;
    }

    public String getDistrict() {
        return district;
    }

    public BigDecimal getMinPrice() { return minPrice; }

    public BigDecimal getMaxPrice() { return maxPrice; }

    public Double getMinArea() {
        return minArea;
    }

    public Double getMaxArea() {
        return maxArea;
    }

    public Integer getMinRooms() {
        return minRooms;
    }

    public Integer getMaxRooms() { return maxRooms; }

    public Integer getMinFloor() { return minFloor; }

    public Integer getMaxFloor() { return maxFloor; }

    public Boolean isHasElevator() {
        return hasElevator;
    }

    public Boolean isSmokingAllowed() {
        return smokingAllowed;
    }

    public Boolean isAnimalAllowed() {
        return animalAllowed;
    }

    public Boolean isOnlyLongTerm() {
        return onlyLongTerm;
    }

    public UserPreferences(PlaceType placeType,
                           String city,
                           String district,
                           BigDecimal minPrice,
                           BigDecimal maxPrice,
                           Double minArea,
                           Double maxArea,
                           Integer minRooms,
                           Integer maxRooms,
                           Integer minFloor,
                           Integer maxFloor,
                           Boolean hasElevator,
                           Boolean smokingAllowed,
                           Boolean animalAllowed,
                           Boolean onlyLongTerm) {
        this.placeType = placeType;
        this.city = city;
        this.district = district;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.minArea = minArea;
        this.maxArea = maxArea;
        this.minRooms = minRooms;
        this.maxRooms = maxRooms;
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
        this.hasElevator = hasElevator;
        this.smokingAllowed = smokingAllowed;
        this.animalAllowed = animalAllowed;
        this.onlyLongTerm = onlyLongTerm;
    }
}
