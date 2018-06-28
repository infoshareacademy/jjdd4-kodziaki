package com.infoshare.kodziaki;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class GetUserPreferences {

    public UserPreferences getUserPreferences() {

        displayHeading();

        // builder poczebny?

        return new UserPreferencesBuilder()
                .setPlaceType(getPlaceType("Typ nieruchomości (mieszkanie,pokój,miejsce w pokoju): "))
                .setCity(getCity("Miasto: "))
                .setDistrict(getDistrict(getCity("Miasto"), "Dzielnica: "))                           //do ogarnięcia getCity :(
                .setMinPrice(getBigDecimalParameter("Cena (od): "))
                .setMaxPrice(getBigDecimalParameter("Cena (do): "))
                .setMinArea(getBigDecimalParameter("Powierzchnia (od): "))
                .setMaxArea(getBigDecimalParameter("Powierzchnia (do): "))
                .setRooms(getIntegerParameter("Ilość pokoi (od 1 do 4): "))
                .setHasElevator(getBooleanParameter("Winda w bloku (tak,nie): "))
                .setSmokingAllowed(getBooleanParameter("Palenie dozwolone (tak,nie): "))
                .setAnimalAllowed(getBooleanParameter("Zwierzęta dozwolone (tak,nie): "))
                .setOnlyLongTerm(getBooleanParameter("Wynajem długoterminowy (tak,nie): "))
                .createUserPreferences();
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
        return getPlaceType("Niepoprawna wartość. Wpisz jeszcze raz (mieszkanie, pokój, miejsce w pokoju): "); // ????????
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
        if (parameter.equals("")) return null;
        else if (listOfCities.stream().noneMatch(c -> c.equalsIgnoreCase(parameter)))
            return getCity("Niepoprawna wartość. Podaj jeszcze raz: ");
        return parameter;
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
        if (parameter.equals("")) return null;
        else if (listOfDistricts.stream().noneMatch(c -> c.equalsIgnoreCase(parameter)))
            return getDistrict(city, "Niepoprawna wartość. Podaj jeszcze raz: ");
        return parameter;
    }

    private BigDecimal getBigDecimalParameter(String message) {
        System.out.println(message);
        String parameter = getUserInput();
        if (parameter.equals("")) return null;
        else if (parameter.matches("[0-9]+")) return BigDecimal.valueOf(Double.parseDouble(parameter));
        return getBigDecimalParameter("Niepoprawna wartość. Podaj jeszcze raz: ");                             // ??????
    }

    private Integer getIntegerParameter(String message) {
        System.out.println(message);
        String parameter = getUserInput();
        if (parameter.equals("")) return null;
        else if (parameter.matches("[1-4]+")) return Integer.parseInt(parameter);
        return getIntegerParameter("Niepoprawna wartość. Podaj jeszcze raz: ");                          // ??????
    }

    private Boolean getBooleanParameter(String message) {
        System.out.println(message);
        String parameter = getUserInput();
        if (parameter.equals("")) return null;
        else if (parameter.equalsIgnoreCase("tak")) return true;
        else if (parameter.equalsIgnoreCase("nie")) return false;
        return getBooleanParameter("Niepoprawna wartość. Podaj jeszcze raz: ");                          // ??????
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
