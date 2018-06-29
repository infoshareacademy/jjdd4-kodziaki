package com.infoshare.kodziaki;

import java.math.BigDecimal;

public class UserPreferences {

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

    public PlaceType getPlaceType() {
        return placeType;
    }

    public String getCity() {
        return city;
    }

    public String getDistrict() {
        return district;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public BigDecimal getMinArea() {
        return minArea;
    }

    public BigDecimal getMaxArea() {
        return maxArea;
    }

    public Integer getRooms() {
        return rooms;
    }

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

    public void setPlaceType(PlaceType placeType) {
        this.placeType = placeType;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }

    public void setMinArea(BigDecimal minArea) {
        this.minArea = minArea;
    }

    public void setMaxArea(BigDecimal maxArea) {
        this.maxArea = maxArea;
    }

    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    public void setHasElevator(Boolean hasElevator) {
        this.hasElevator = hasElevator;
    }

    public void setSmokingAllowed(Boolean smokingAllowed) {
        this.smokingAllowed = smokingAllowed;
    }

    public void setAnimalAllowed(Boolean animalAllowed) {
        this.animalAllowed = animalAllowed;
    }

    public void setOnlyLongTerm(Boolean onlyLongTerm) {
        this.onlyLongTerm = onlyLongTerm;
    }

    @Override
    public String toString() {
        return "UserPreferences{" +
                "placeType=" + placeType +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                ", minArea=" + minArea +
                ", maxArea=" + maxArea +
                ", rooms=" + rooms +
                ", hasElevator=" + hasElevator +
                ", smokingAllowed=" + smokingAllowed +
                ", animalAllowed=" + animalAllowed +
                ", onlyLongTerm=" + onlyLongTerm +
                '}';
    }
}
