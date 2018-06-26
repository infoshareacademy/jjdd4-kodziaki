package com.infoshare.kodziaki;

import com.infoshare.kodziaki.Place;
import com.infoshare.kodziaki.placeType;

import java.util.ArrayList;
import java.util.List;

import static com.infoshare.kodziaki.placeType.ROOM;

public class Notice {
    public static void notice() {
        List<Place> notice = new ArrayList<>();


        notice.add
                (new Place(
                        "Ogloszenie1",
                        placeType.APARTMENT,
                        1500,
                        45,
                        2,
                        2,
                        "Oliwa",
                        "Gdańsk",
                        true,
                        false,
                        false,
                        true,
                        "...dmjeidfmnefimn"));

        notice.add(new Place(
                "Ogloszenie2",
                ROOM,
                1200,
                39,
                2,
                5,
                "Bałuty",
                "Łódz",
                true,
                false,
                true,
                false,
                "opis...ikmjefi"));


        for( Place a : notice ){
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





