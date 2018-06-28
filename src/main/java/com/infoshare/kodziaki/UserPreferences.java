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

    public UserPreferences(PlaceType placeType,
                           String city,
                           String district,
                           BigDecimal minPrice,
                           BigDecimal maxPrice,
                           BigDecimal minArea,
                           BigDecimal maxArea,
                           Integer rooms,
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
        this.rooms = rooms;
        this.hasElevator = hasElevator;
        this.smokingAllowed = smokingAllowed;
        this.animalAllowed = animalAllowed;
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
