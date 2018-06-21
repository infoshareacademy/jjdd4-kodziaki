package com.infoshare.kodziaki;

import java.math.BigDecimal;

public class Place {
    int id;
    private placeType placeType;

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

    public void setId(int id) { this.id = id; }

    public void setPlaceType(com.infoshare.kodziaki.placeType placeType) { this.placeType = placeType; }

    public void setPrice(BigDecimal price) { this.price = price; }

    public void setArea(double area) { this.area = area; }

    public void setRooms(int rooms) { this.rooms = rooms; }

    public void setFloor(int floor) { this.floor = floor; }

    public void setDistrict(String district) { this.district = district; }

    public void setCity(String city) { this.city = city; }

    public void setDescription(String description) { this.description = description; }

    public void setTitle(String title) { this.title = title; }

    public void setHasElevator(boolean hasElevator) { this.hasElevator = hasElevator; }

    public void setSmokingAllowed(boolean smokingAllowed) { this.smokingAllowed = smokingAllowed; }

    public void setAnimalAllowed(boolean animalAllowed) { this.animalAllowed = animalAllowed; }

    public void setOnlyLongTerm(boolean onlyLongTerm) { this.onlyLongTerm = onlyLongTerm; }

}
