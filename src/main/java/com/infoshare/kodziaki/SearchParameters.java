package com.infoshare.kodziaki;

import java.math.BigDecimal;

public class SearchParameters {

    private PlaceType placeType;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private BigDecimal minArea;
    private BigDecimal maxArea;
    private Integer rooms;
    private String city;
    private String district;

    private Boolean hasElevator;
    private Boolean smokingAllowed;
    private Boolean animalAllowed;
    private Boolean onlyLongTerm;

    public PlaceType getPlaceType() {
        return placeType;
    }

    public void setPlaceType(PlaceType placeType) {
        this.placeType = placeType;
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

    public String getCity() {
        return city;
    }

    public String getDistrict() {
        return district;
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
}
