package com.infoshare.kodziaki;

import java.util.List;

public class ViewPlaceAds {

    public static void viewPlaceAds(List<Place> list) {
        for( Place a : list ){
            System.out.println(
                    "\n | " + a.getTitle() + "\n  ");
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
                              "\n | Cena: " + a.getPrice() + " " + Properties.getCurrency()
                            + "\n"
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
                            + "\n | Kontakt: " + a.getPhoneNumber()
                            + "\n "
                            + "\n | Autor: " + a.getAuthor()
                            + "\n "
                            + "\n "); }
    }
}