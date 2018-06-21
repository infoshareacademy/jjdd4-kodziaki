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
}
