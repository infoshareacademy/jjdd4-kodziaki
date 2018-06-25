package com.infoshare.kodziaki;

import java.util.List;
import java.util.Scanner;

public class GetUserPreferences {

    public static void getType() {

    }

    public static void getPriceRange() {

    }

    public static void getAreaRange() {

    }

    public static void getMoreParameters() {

    }

    public static void getUserPreferences() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Opcje wyszukiwania");
        System.out.println("------------------");
        System.out.println("|1 Typ nieruchomości");
        System.out.println("|2 Cena");
        System.out.println("|3 Powierzchnia");
        System.out.println("|4 więcej opcji");

        switch (scanner.nextInt()) {
            case 1: GetUserPreferences.getType();
            case 2: GetUserPreferences.getPriceRange();
            case 3: GetUserPreferences.getAreaRange();
            case 4: GetUserPreferences.getMoreParameters();
        }



//
//
//
//        System.out.println("Czego poszukujesz?");
//        System.out.println("1. Mieszkanie | 2. Pokój | 3. Miejsce w pokoju ");
//        int scanner.nextInt();
//
//        System.out.println("W jakiej cenie?");
//        System.out.print("od: ");
//        scanner.nextInt();
//        System.out.print("do: ");
//        scanner.nextInt();
//
//        System.out.println("Powierzchnia: ");
//        System.out.print("od: ");
//        scanner.nextInt();
//        System.out.print("do: ");
//        scanner.nextInt();



    }

    public static List<Place> sortAdsByPreferences (List<Place> adsList) {

        return adsList;
    }
}
