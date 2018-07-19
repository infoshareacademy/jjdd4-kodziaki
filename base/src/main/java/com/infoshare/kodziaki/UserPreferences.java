package com.infoshare.kodziaki;

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

    public void setPlaceType(PlaceType placeType) { this.placeType = placeType; }

    public void setCity(String city) { this.city = city; }

    public void setDistrict(String district) { this.district = district; }

    public void setMinPrice(BigDecimal minPrice) { this.minPrice = minPrice; }

    public void setMaxPrice(BigDecimal maxPrice) { this.maxPrice = maxPrice; }

    public void setMinArea(Double minArea) { this.minArea = minArea; }

    public void setMaxArea(Double maxArea) { this.maxArea = maxArea; }

    public void setMinRooms(Integer minRooms) { this.minRooms = minRooms; }

    public void setMaxRooms(Integer maxRooms) { this.maxRooms = maxRooms; }

    public void setMinFloor(Integer minFloor) { this.minFloor = minFloor; }

    public void setMaxFloor(Integer maxFloor) { this.maxFloor = maxFloor; }

    public void setHasElevator(Boolean hasElevator) { this.hasElevator = hasElevator; }

    public void setSmokingAllowed(Boolean smokingAllowed) { this.smokingAllowed = smokingAllowed; }

    public void setAnimalAllowed(Boolean animalAllowed) { this.animalAllowed = animalAllowed; }

    public void setOnlyLongTerm(Boolean onlyLongTerm) { this.onlyLongTerm = onlyLongTerm; }

    public UserPreferences() {

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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UserPreferences{");
        sb.append("placeType=").append(placeType);
        sb.append(", city='").append(city).append('\'');
        sb.append(", district='").append(district).append('\'');
        sb.append(", minPrice=").append(minPrice);
        sb.append(", maxPrice=").append(maxPrice);
        sb.append(", minArea=").append(minArea);
        sb.append(", maxArea=").append(maxArea);
        sb.append(", minRooms=").append(minRooms);
        sb.append(", maxRooms=").append(maxRooms);
        sb.append(", minFloor=").append(minFloor);
        sb.append(", maxFloor=").append(maxFloor);
        sb.append(", hasElevator=").append(hasElevator);
        sb.append(", smokingAllowed=").append(smokingAllowed);
        sb.append(", animalAllowed=").append(animalAllowed);
        sb.append(", onlyLongTerm=").append(onlyLongTerm);
        sb.append('}');
        return sb.toString();
    }
}
