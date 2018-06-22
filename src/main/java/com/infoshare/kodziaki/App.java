package com.infoshare.kodziaki;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        List<Place> notice = new ArrayList<>();


        notice.add
                (new Place(
                1,
                "Ogloszenie",
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
                2,
                "Ogloszenie2",
                 placeType.ROOM,
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
                    "| id: " + a.getId()
                    + "\n | Typ ogloszenia: "+ a.getPlaceType()
                    + "\n | cena: "+ a.getPrice()
                    + "\n | Powierzchnia: " + a.getArea()
                    + "\n | Liczba Pokoi:  " + a.getRooms()
                    + "\n | Piętro: " + a.getFloor()
                    + "\n | Dzielnica: " + a.getDistrict()
                    + "\n | Miasto: " + a.getCity()
                    + "\n | Opis: "+ a.getDescription()
                    + "\n | Tytuł: " + a.getTitle()
                    + "\n | Winda:  "+ a.isHasElevator()
                    + "\n | Palący: "+ a.isSmokingAllowed()
                    + "\n | Posiadanie zwierząt: " + a.isAnimalAllowed()
                    + "\n | Dlugoterminowa umowa: "+ a.isOnlyLongTerm() );

        }



    }

}
