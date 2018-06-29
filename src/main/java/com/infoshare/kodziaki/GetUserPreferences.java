package com.infoshare.kodziaki;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class GetUserPreferences {

    public UserPreferences getUserPreferences() {

        displayHeading();

        UserPreferences userPreferences = new UserPreferences();
        userPreferences.setPlaceType(getPlaceType("Typ nieruchomości (mieszkanie,pokój,miejsce w pokoju): "));
        userPreferences.setCity(getCity("Miasto: "));
        userPreferences.setDistrict(getDistrict(userPreferences.getCity(), "Dzielnica: "));
        userPreferences.setMinPrice(getBigDecimalParameter("Cena min (zł): "));
        userPreferences.setMaxPrice(getBigDecimalParameter("Cena max (zł): "));
        userPreferences.setMinArea(getBigDecimalParameter("Powierzchnia min (m2): "));
        userPreferences.setMaxArea(getBigDecimalParameter("Powierzchnia max (m2): "));
        userPreferences.setRooms(getIntegerParameter("Ilość pokoi (od 1 do 4): "));
        userPreferences.setHasElevator(getBooleanParameter("Winda w bloku (tak,nie): "));
        userPreferences.setSmokingAllowed(getBooleanParameter("Palenie dozwolone (tak,nie): "));
        userPreferences.setAnimalAllowed(getBooleanParameter("Zwierzęta dozwolone (tak,nie): "));
        userPreferences.setOnlyLongTerm(getBooleanParameter("Wynajem długoterminowy (tak,nie): "));

        return userPreferences;
    }

    private void displayHeading() {
        System.out.println("Podaj opcje wyszukiwania");
        System.out.println("(aby pominąć podanie parametru naciśnij ENTER)");
        System.out.println("------------------------");
    }

    private PlaceType getPlaceType(String message) {
        System.out.println(message);
        String parameter = getUserInput();
        switch (parameter.toLowerCase()) {
            case "mieszkanie":
                return PlaceType.APARTMENT;
            case "pokój":
                return PlaceType.ROOM;
            case "miejsce w pokoju":
                return PlaceType.BED;
            case "":
                return null;
        }
        return getPlaceType("Niepoprawna wartość. Wpisz jeszcze raz (mieszkanie, pokój, miejsce w pokoju): ");
    }

    private String getCity(String message) {
        System.out.println(message);
        List<String> listOfCities = generateAdsList()
                .stream()
                .map(Place::getCity)
                .distinct()
                .peek(System.out::println)
                .collect(Collectors.toList());
        String parameter = getUserInput();
        if (parameter.equals("")) {
            return null;
        } else if (listOfCities.stream().noneMatch(c -> c.equalsIgnoreCase(parameter))) {
            return getCity("Niepoprawna wartość. Podaj jeszcze raz: ");
        }
        return processParameter(parameter);
    }

    private String getDistrict(String city, String message) {
        System.out.println(message);
        List<String> listOfDistricts = generateAdsList()
                .stream()
                .filter(p -> p.getCity().equalsIgnoreCase(city))
                .map(Place::getDistrict)
                .distinct()
                .peek(System.out::println)
                .collect(Collectors.toList());
        String parameter = getUserInput();
        if (parameter.equals("")) {
            return null;
        } else if (listOfDistricts.stream().noneMatch(c -> c.equalsIgnoreCase(parameter))) {
            return getDistrict(city, "Niepoprawna wartość. Podaj jeszcze raz: ");
        }
        return processParameter(parameter);
    }

    private BigDecimal getBigDecimalParameter(String message) {
        System.out.println(message);
        String parameter = getUserInput();
        if (parameter.equals("")) {
            return null;
        } else if (parameter.matches("[0-9]+")) {
            return BigDecimal.valueOf(Double.parseDouble(parameter));
        }
        return getBigDecimalParameter("Niepoprawna wartość. Podaj jeszcze raz: ");
    }

    private Integer getIntegerParameter(String message) {
        System.out.println(message);
        String parameter = getUserInput();
        if (parameter.equals("")) {
            return null;
        } else if (parameter.matches("[1-4]+")) {
            return Integer.parseInt(parameter);
        }
        return getIntegerParameter("Niepoprawna wartość. Podaj jeszcze raz: ");
    }

    private Boolean getBooleanParameter(String message) {
        System.out.println(message);
        String parameter = getUserInput().toLowerCase();
        if (parameter.equals("")) {
            return null;
        } else if (parameter.equals("tak")) {
            return true;
        } else if (parameter.equals("nie")) {
            return false;
        }
        return getBooleanParameter("Niepoprawna wartość. Podaj jeszcze raz: ");
    }

    String processParameter(String input) {
        String firstSing = String.valueOf(input.charAt(0)).toUpperCase();
        String restOfInput = input.substring(1).toLowerCase();
        return firstSing + restOfInput;
    }

    private String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private List<Place> generateAdsList() {
        List<Place> listOfAds = null;
        try {
            listOfAds = CsvReader.readFile(new FileReader("files/ads.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return listOfAds;
    }

}
