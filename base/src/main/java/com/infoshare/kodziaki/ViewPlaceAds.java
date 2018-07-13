package com.infoshare.kodziaki;

import com.infoshare.kodziaki.domain.Place;

import java.util.List;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class ViewPlaceAds {
    

    public static void viewPlaceAds(List<Place> list) {
        
        NumberFormat formatter = new DecimalFormat("#0.00");
        
        for( Place a : list ){
            System.out.println(
                    "=================================================="
                    + "\n | " + a.getTitle().toUpperCase() + "\n  ");
            switch (a.getPlaceType()) {
                case ROOM:
                    System.out.println(" | Do wynajęcia: Pokój");
                    break;

                case APARTMENT:
                    System.out.println(" | Do wynajęcia: Mieszkanie");
                    break;

                case BED:
                    System.out.println(" | Do wynajęcia: Miejsce w pokoju");
                    break;
            }
             
            System.out.println(
                              "\n | Cena: " + formatter.format(a.getPrice()) + " " + Properties.getCurrency()
                            + "\n | Powierzchnia: " + a.getArea() + " m2"
                            + "\n | Liczba Pokoi:  " + a.getRooms()
                            + "\n | Piętro: " + a.getFloor()
                            + "\n | Dzielnica: " + a.getDistrict()
                            + "\n | Miasto: " + a.getCity()
                            + "\n | Winda:  " + (a.isHasElevator() ? "Tak" : "Nie")
                            + "\n | Palący: " + (a.isSmokingAllowed() ? "Tak" : "Nie")
                            + "\n | Posiadanie zwierząt: " + (a.isAnimalAllowed() ? "Tak" : "Nie")
                            + "\n | Dlugoterminowa umowa: " + (a.isOnlyLongTerm() ? "Tak" : "Nie")
                            + "\n | Opis: " + a.getDescription()
                            + "\n | Kontakt: " + a.getPhoneNumber()
                            + "\n | Autor: " + a.getAuthor()
                            + "\n"
                            + "=================================================="
                            + "\n\n "); }
    }
}