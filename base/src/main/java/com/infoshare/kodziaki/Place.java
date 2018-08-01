package com.infoshare.kodziaki;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.registry.infomodel.User;
import java.math.BigDecimal;

@Entity
@Table(name = "ADS")
public class Place {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "placeType")
    @NotNull
    private PlaceType placeType;

    @Column(name = "price")
    @NotNull
    private BigDecimal price;

    @Column(name = "area")
    @NotNull
    private double area;

    @Column(name = "rooms")
    @NotNull
    private int rooms;

    @Column(name = "floor")
    @NotNull
    private int floor;

    @Column(name = "district")
    @NotNull
    private String district;

    @Column(name = "city")
    @NotNull
    private String city;

    @Column(name = "description", length = 2048)
    @NotNull
    private String description;

    @Column(name = "title")
    @NotNull
    private String title;

    @Column(name = "hasElevator", columnDefinition = "BOOLEAN")
    @NotNull
    private boolean hasElevator;

    @Column(name = "smokingAllowed", columnDefinition = "BOOLEAN")
    @NotNull
    private boolean smokingAllowed;

    @Column(name = "animalAllowed", columnDefinition = "BOOLEAN")
    @NotNull
    private boolean animalAllowed;

    @Column(name = "onlyLongTerm", columnDefinition = "BOOLEAN")
    @NotNull
    private boolean onlyLongTerm;

    @Column(name = "author")
    @NotNull
    private String author;

    @Column(name = "phoneNumber")
    @NotNull
    private String phoneNumber;

    @Column(name = "promoted")
    private boolean isPromoted;

    @Column(name = "visits")
    private long visits;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Place() {

    }

    public Place(int id,
                 String title,
                 PlaceType placeType,
                 BigDecimal price,
                 double area,
                 int rooms,
                 int floor,
                 String district,
                 String city,
                 boolean hasElevator,
                 boolean smokingAllowed,
                 boolean animalAllowed,
                 boolean onlyLongTerm,
                 String description,
                 String author,
                 String phoneNumber,
                 User user) {
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
        this.author = author;
        this.phoneNumber = phoneNumber;
        this.user = user;
    }

    public int getId() { return id; }

    public PlaceType getPlaceType() { return placeType; }

    public BigDecimal getPrice() { return price; }

    public double getArea() { return area; }

    public int getRooms() { return rooms; }

    public int getFloor() { return floor; }

    public String getDistrict() { return district; }

    public String getCity() { return city; }

    public String getDescription() { return description; }

    public String getTitle() { return title; }

    public boolean isHasElevator() { return hasElevator; }

    public boolean isSmokingAllowed() { return smokingAllowed; }

    public boolean isAnimalAllowed() { return animalAllowed; }

    public boolean isOnlyLongTerm() { return onlyLongTerm; }

    public String getAuthor() { return author; }

    public String getPhoneNumber() { return phoneNumber; }

    public boolean isPromoted() { return isPromoted; }

    public long getVisits() { return visits; }

    public void setId(int id) { this.id = id; }

    public void setPlaceType(PlaceType placeType) { this.placeType = placeType; }

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

    public void setAuthor(String author) { this.author = author; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public void setPromoted(boolean promoted) { isPromoted = promoted; }

    public void setVisits(long visits) { this.visits = visits; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

}