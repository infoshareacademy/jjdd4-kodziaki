package com.infoshare.kodziaki;

import java.util.ArrayList;
import java.util.List;

import static com.infoshare.kodziaki.placeType.APARTMENT;
import static com.infoshare.kodziaki.placeType.BED;
import static com.infoshare.kodziaki.placeType.ROOM;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
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

        DisplayAd.displayAd(notice);

        }
}










