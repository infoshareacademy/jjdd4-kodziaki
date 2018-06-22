package com.infoshare.kodziaki;

import java.math.BigDecimal;

public class Place {
    int id;
    private placeType placeType;

    public double getPrice() {
        return price;
    }

    private double price;

    public double getArea() {
        return area;
    }

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

    public Place() { }

    public Place(int id,
                 String title,
                 placeType placeType,
                 double price,
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
        this.id = id;
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

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", placeType=" + placeType +
                ", price=" + price +
                ", area=" + area +
                ", rooms=" + rooms +
                ", floor=" + floor +
                ", district='" + district + '\'' +
                ", city='" + city + '\'' +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                ", hasElevator=" + hasElevator +
                ", smokingAllowed=" + smokingAllowed +
                ", animalAllowed=" + animalAllowed +
                ", onlyLongTerm=" + onlyLongTerm +
                '}';
    }
}
