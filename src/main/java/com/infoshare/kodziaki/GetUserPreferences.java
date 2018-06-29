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

        userPreferences.setMinPrice(promptUserWithMessage("Cena min (zł): "));
        userPreferences.setMaxPrice(promptUserWithMessage("Cena max (zł): "));
        userPreferences.setMinArea(promptUserWithMessage("Powierzchnia min (m2): "));
        userPreferences.setMaxArea(promptUserWithMessage("Powierzchnia max (m2): "));

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
        if (listOfDistricts.size() == 1) {
            return listOfDistricts.get(0);
        }
        String parameter = getUserInput();
        if (parameter.equals("")) {
            return null;
        } else if (listOfDistricts.stream().noneMatch(c -> c.equalsIgnoreCase(parameter))) {
            return getDistrict(city, "Niepoprawna wartość. Podaj jeszcze raz: ");
        }
        return processParameter(parameter);
    }

    private Integer getIntegerParameter(String message) {
        System.out.println(message);
        String parameter = getUserInput();
        if (parameter.equals("")) {
            return null;
        } else if (parameter.matches("[1-9]+")) {
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

    BigDecimal promptUserWithMessage(String message) {
        boolean askUserForValue = true;
        System.out.println(message);
        while(askUserForValue) {
            String userInput = getUserInput();
            if (isCorrectInput(userInput)) {
                return userInput.equals("") ? null : new BigDecimal(userInput);
            }
        }
        return null;
    }

    boolean isCorrectInput(String input) {
        String message = "";

        if (input.isEmpty()){
            return true;
        }

        try {
            if (Double.parseDouble(input) < 0) {
                message = "Niepoprawna wartość. Podaj jeszcze raz: ";
            }
        } catch (Exception e) {
            message = "Niepoprawna wartość (format danych). Podaj jeszcze raz: ";
        }

        if (!message.isEmpty()) {
            System.out.println(message);
            return false;
        }

        return true;
    }





}
