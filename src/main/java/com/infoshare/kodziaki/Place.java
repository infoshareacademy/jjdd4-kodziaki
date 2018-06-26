package com.infoshare.kodziaki;

public class Place {
    private placeType placeType;

    private int price;
    private double area;
    private int rooms;
    private int floor;

    private String district;
    private String city;


    private String title;

    private boolean hasElevator;
    private boolean smokingAllowed;
    private boolean animalAllowed;
    private boolean onlyLongTerm;
    private String description;

    public Place() {}

    public Place(String title,
                 placeType placeType,
                 int price,
                 double area,
                 int rooms,
                 int floor,
                 String district,
                 String city,
                 boolean hasElevator,
                 boolean smokingAllowed,
                 boolean animalAllowed,
                 boolean onlyLongTerm,
                 String description) {

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
    }



    public placeType getPlaceType() { return placeType; }

    public int getPrice() { return price; }

    public double getArea() { return area; }

    public int getRooms() { return rooms; }

    public int getFloor() { return floor; }

    public String getDistrict() { return district; }

    public String getCity() { return city; }

    public String getTitle() { return title; }

    public boolean isHasElevator() { return hasElevator; }

    public boolean isSmokingAllowed() { return smokingAllowed; }

    public boolean isAnimalAllowed() { return animalAllowed; }

    public boolean isOnlyLongTerm() { return onlyLongTerm; }

    public String getDescription() { return description; }
}