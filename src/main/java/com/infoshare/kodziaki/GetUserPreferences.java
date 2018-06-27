package com.infoshare.kodziaki;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetUserPreferences {

    private static String getPlaceType() {
        System.out.println("Typ nieruchomości (mieszkanie,pokój,miejsce w pokoju): ");
        Scanner scanner = new Scanner(System.in);
        String parameter = scanner.nextLine();
        if (parameter.equals("")) return "";
        while( !(parameter.equals("mieszkanie") || parameter.equals("pokój") || parameter.equals("miejsce w pokoju")) ) {
            System.out.println("Niepoprawna wartość. Podaj jeszcze raz: ");
            parameter = scanner.next();
        }
        return parameter;
    }

    private static String getMinPrice() {
        System.out.println("Cena (od): ");
        Scanner scanner = new Scanner(System.in);
        String parameter = scanner.nextLine();
        if (parameter.equals("")) return "";
        while(!(parameter.matches("[0-9]+"))) {
            System.out.println("Niepoprawna wartość. Podaj jeszcze raz: ");
            parameter = scanner.nextLine();
        }
        return parameter;
    }

    private static String getMaxPrice() {
        System.out.println("Cena (do): ");
        Scanner scanner = new Scanner(System.in);
        String parameter = scanner.nextLine();
        if (parameter.equals("")) return "";
        while(!(parameter.matches("[0-9]+"))) {
            System.out.println("Niepoprawna wartość. Podaj jeszcze raz: ");
            parameter = scanner.nextLine();
        }
        return parameter;
    }

    private static String getMinArea() {
        System.out.println("Powierzchnia (od): ");
        Scanner scanner = new Scanner(System.in);
        String parameter = scanner.nextLine();
        if (parameter.equals("")) return "";
        while(!(parameter.matches("[0-9]+"))) {
            System.out.println("Niepoprawna wartość. Podaj jeszcze raz: ");
            parameter = scanner.nextLine();
        }
        return parameter;
    }

    private static String getMaxArea() {
        System.out.println("Powierzchnia (do): ");
        Scanner scanner = new Scanner(System.in);
        String parameter = scanner.nextLine();
        if (parameter.equals("")) return "";
        while(!(parameter.matches("[0-9]+"))) {
            System.out.println("Niepoprawna wartość. Podaj jeszcze raz: ");
            parameter = scanner.nextLine();
        }
        return parameter;
    }

    private static String getNumberOfRooms() {
        System.out.println("Liczba pokoi: ");
        Scanner scanner = new Scanner(System.in);
        String parameter = scanner.nextLine();
        if (parameter.equals("")) return "";
        while(!(parameter.matches("[1-4]+"))) {
            System.out.println("Niepoprawna wartość. Podaj jeszcze raz: ");
            parameter = scanner.nextLine();
        }
        return parameter;
    }

    private static String getOtherParameter(String message) {

        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        String parameter = scanner.nextLine();
        if (parameter.equals("")) return "";
        while( !(parameter.equals("tak") || parameter.equals("nie")) ) {
            System.out.println("Niepoprawna wartość. Podaj jeszcze raz: ");
            parameter = scanner.nextLine();
        }
        return parameter;
    }

    public static List<String> getUserPreferences() {

        System.out.println("Podaj opcje wyszukiwania");
        System.out.println("(aby pominąć podanie parametru naciśnij ENTER)");
        System.out.println("------------------------");

        List<String> userPreferences = new ArrayList<>();
        userPreferences.add(getPlaceType());
        userPreferences.add(getMinPrice());
        userPreferences.add(getMaxPrice());
        userPreferences.add(getMinArea());
        userPreferences.add(getMaxArea());
        userPreferences.add(getNumberOfRooms());
//        userPreferences.add(getCity());
//        userPreferences.add(getDistrict());
        userPreferences.add(getOtherParameter("Winda w bloku (tak,nie): "));
        userPreferences.add(getOtherParameter("Palenie dozwolone (tak,nie): "));
        userPreferences.add(getOtherParameter("Zwierzęta dozwolone (tak,nie): "));
        userPreferences.add(getOtherParameter("Wynajem długoterminowy (tak,nie): "));

        return userPreferences;
    }
}
