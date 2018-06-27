package com.infoshare.kodziaki;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GetUserPreferences {

    private static String getPlaceType() {
        System.out.println("Typ nieruchomości (mieszkanie,pokój,miejsce w pokoju): ");
        String parameter = getUserInput();
        if (parameter.equals("")) return "";
        while( !(parameter.equalsIgnoreCase("mieszkanie")
                || parameter.equalsIgnoreCase("pokój")
                || parameter.equalsIgnoreCase("miejsce w pokoju")) ) {
            parameter = getInputWhenItIsIncorrect();
        }
        return parameter;
    }

    private static String getCity() {
        System.out.println("Miasto: ");
        List<Place> listOfAds = generateAdsList();
        List<String> listOfCities = listOfAds.stream()
                .map(Place::getCity)
                .distinct()
                .peek(System.out::println)
                .collect(Collectors.toList());
        String parameter = getUserInput();
        if (parameter.equals("")) return "";
        while (!listOfCities.contains(parameter)) {
            parameter = getInputWhenItIsIncorrect();
        }
        return parameter;
    }

    private static String getDistrict(String city) {
        System.out.println("Dzielnica: ");
        List<Place> listOfAds = generateAdsList();
        List<String> listOfDistricts = listOfAds.stream()
                .filter(p -> p.getCity().equalsIgnoreCase(city))
                .map(Place::getDistrict)
                .distinct()
                .peek(System.out::println)
                .collect(Collectors.toList());
        String parameter = getUserInput();
        if (parameter.equals("")) return "";
        while (!listOfDistricts.contains(parameter)) {
            parameter = getInputWhenItIsIncorrect();
        }
        return parameter;
    }

    private static String getNumericParameter (String message) {
        System.out.println(message);
        String parameter = getUserInput();
        if (parameter.equals("")) return "";
        while(!(parameter.matches("[0-9]+"))) {
            parameter = getInputWhenItIsIncorrect();
        }
        return parameter;
    }

    private static String getBooleanParameter(String message) {
        System.out.println(message);
        String parameter = getUserInput();
        if (parameter.equals("")) return "";
        while( !(parameter.equals("tak") || parameter.equals("nie")) ) {
            parameter = getInputWhenItIsIncorrect();
        }
        return parameter;
    }

    private static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        String input =  scanner.nextLine();
        return input;
    }

    private static String getInputWhenItIsIncorrect() {
        System.out.println("Niepoprawna wartość. Podaj jeszcze raz: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static List<Place> generateAdsList() {
        List<Place> listOfAds = null;
        try {
            listOfAds = CsvReader.readFile(new FileReader("files/ads.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return listOfAds;
    }

    public static Map<String, String> getUserPreferences() {

        System.out.println("Podaj opcje wyszukiwania");
        System.out.println("(aby pominąć podanie parametru naciśnij ENTER)");
        System.out.println("------------------------");

        Map<String, String> userPreferences = new HashMap<>();

        userPreferences.put("placeType", getPlaceType());
        userPreferences.put("city", getCity());
        userPreferences.put("district", getDistrict(userPreferences.get("city")));
        userPreferences.put("minPrice", getNumericParameter("Cena (od): "));
        userPreferences.put("maxPrice", getNumericParameter("Cena (do): "));
        userPreferences.put("minArea", getNumericParameter("Powierzchnia (od): "));
        userPreferences.put("maxArea", getNumericParameter("Powierzchnia (do): "));
        userPreferences.put("rooms", getNumericParameter("Ilość pokoi (od 1 do 4): "));
        userPreferences.put("hasElevator", getBooleanParameter("Winda w bloku (tak,nie): "));
        userPreferences.put("isSmokingAllowed", getBooleanParameter("Palenie dozwolone (tak,nie): "));
        userPreferences.put("isAnimalsAllowed", getBooleanParameter("Zwierzęta dozwolone (tak,nie): "));
        userPreferences.put("isOnlyLongTerm", getBooleanParameter("Wynajem długoterminowy (tak,nie): "));

        System.out.println(userPreferences.values());
        return userPreferences;
    }
}
