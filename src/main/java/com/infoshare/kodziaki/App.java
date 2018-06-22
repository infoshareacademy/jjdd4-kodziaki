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
                0102,
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
                0103,
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
            System.out.println(a.getId()
                    +" "+ a.getPlaceType()
                    +" "+ a.getPrice()
                    + " " + a.getArea()
                    + " " + a.getRooms()
                    + " " + a.getFloor()
                    + " " + a.getDistrict()
                    +" " + a.getCity()
                    + " "+ a.getDescription()
                    + " " + a.getTitle()
                    + " "+ a.isHasElevator()
                    + " "+ a.isSmokingAllowed()
                    + " " + a.isAnimalAllowed()
                    +" "+ a.isOnlyLongTerm() );

        }



    }

}
