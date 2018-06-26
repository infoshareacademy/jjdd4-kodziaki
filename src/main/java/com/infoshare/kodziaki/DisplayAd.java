package com.infoshare.kodziaki;

import com.infoshare.kodziaki.Place;
import com.infoshare.kodziaki.placeType;

import java.util.ArrayList;
import java.util.List;

import static com.infoshare.kodziaki.placeType.ROOM;

public class DisplayAd {
    public static void displayAd(List<Place> list) {

        for( Place a : list ){
            System.out.println(
                              "\n | " + a.getTitle()
                            + "\n  ");

            switch (a.getPlaceType()) {
                case ROOM:
                    System.out.println(" | Do wynajęcia: Pokój");
                    break;

                case APARTMENT:
                    System.out.println(" | Do wynajęcia: Apartament");
                    break;

                case BED:
                    System.out.println(" | Do wynajęcia: Łóżko");
                    break;
            }


            System.out.println(
                              "\n | Cena: " + a.getPrice() + "zł"
                            + "\n "
                            + "\n | Powierzchnia: " + a.getArea() + "m2"
                            + "\n "
                            + "\n | Liczba Pokoi:  " + a.getRooms()
                            + "\n "
                            + "\n | Piętro: " + a.getFloor()
                            + "\n "
                            + "\n | Dzielnica: " + a.getDistrict()
                            + "\n"
                            + "\n | Miasto: " + a.getCity()
                            + "\n "
                            + "\n | Winda:  " + (a.isHasElevator() ? "Tak" : "Nie")
                            + "\n "
                            + "\n | Palący: " + (a.isSmokingAllowed() ? "Tak" : "Nie")
                            + "\n "
                            + "\n | Posiadanie zwierząt: " + (a.isAnimalAllowed() ? "Tak" : "Nie")
                            + "\n "
                            + "\n | Dlugoterminowa umowa: " + (a.isOnlyLongTerm() ? "Tak" : "Nie")
                            + "\n "
                            + "\n | Opis: " + a.getDescription()
                            + "\n "
                            + "\n "
                            + "\n ");


        }
    }
}





