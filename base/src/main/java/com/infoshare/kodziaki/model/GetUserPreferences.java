package com.infoshare.kodziaki.model;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class GetUserPreferences {

    public UserPreferences getUserPreferences(List<Place> adsList) {

        System.out.println("\n"
                + "\n=============================================="
                + "\nPodaj opcje wyszukiwania."
                + "\n==============================================");

        UserPreferences userPreferences = new UserPreferences();
        userPreferences.setPlaceType(receivePlaceType());
        userPreferences.setCity(receiveCity(adsList));
        userPreferences.setDistrict(receiveDistrict(userPreferences.getCity(), adsList));
        userPreferences.setMinPrice(receiveBigDecimalValue("Min. cena [" + Properties.getCurrency() + "] "));
        userPreferences.setMaxPrice(receiveBigDecimalValue("Max. cena [" + Properties.getCurrency() + "] "));
        userPreferences.setMinArea(receiveDoubleValue("Min. powierzchnia [m2] "));
        userPreferences.setMaxArea(receiveDoubleValue("Max. powierzchnia [m2] "));
        userPreferences.setMinRooms(receiveIntegerValue("Min. liczba pokoi "));
        userPreferences.setMaxRooms(receiveIntegerValue("Max. liczba pokoi "));
        userPreferences.setMinFloor(receiveIntegerValue("Piętro (od) "));
        userPreferences.setMaxFloor(receiveIntegerValue("Piętro (do) "));
        userPreferences.setHasElevator(receiveYesOrNo("Winda "));
        userPreferences.setSmokingAllowed(receiveYesOrNo("Palenie dozwolone "));
        userPreferences.setAnimalAllowed(receiveYesOrNo("Zwierzęta dozwolone "));
        userPreferences.setOnlyLongTerm(receiveYesOrNo("Wynajem długoterminowy "));

        return userPreferences;
    }

    private String receiveUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private PlaceType receivePlaceType() {
        System.out.println("Typ ogłoszenia (wpisz 1, 2 lub 3, ENTER aby pominąć): ");
        System.out.println("1| Mieszkanie");
        System.out.println("2| Pokój");
        System.out.println("3| Miejsce w pokoju");

        boolean askUserForValue = true;
        while (askUserForValue) {
            switch (receiveUserInput()) {
                case "1":
                    return PlaceType.APARTMENT;
                case "2":
                    return PlaceType.ROOM;
                case "3":
                    return PlaceType.BED;
                case "":
                    return null;
                default:
                    System.out.println("Niepoprawna wartość. Wpisz 1, 2 lub 3:");
            }
        }
        return null;
    }

    private String receiveCity(List<Place> adsList) {
        System.out.println("Wybierz miasto (ENTER aby pominąć):");

        List<String> cities = adsList
                .stream()
                .map(Place::getCity)
                .distinct()
                .peek(c -> System.out.println(" |".concat(c)))
                .collect(Collectors.toList());

        boolean askUserForValue = true;
        while (askUserForValue) {
            String parameter = receiveUserInput();
            if (parameter.isEmpty()) {
                return null;
            }
            try {
                return cities
                        .stream()
                        .filter(city -> city.equalsIgnoreCase(parameter))
                        .findAny()
                        .get();
            } catch (Exception e) {
                System.out.println("Niepoprawna wartość. Wpisz jeszcze raz:");
            }
        }
        return null;
    }

    private String receiveDistrict(String city, List<Place> adsList) {
        System.out.println("Wybierz dzielnicę (ENTER aby pominąć):");
        if (city != null) {
            adsList = adsList.stream()
                    .filter(ad -> ad.getCity().equals(city))
                    .collect(Collectors.toList());
        }

        Map<String, Set<String>> districts = adsList.stream()
                .collect(Collectors
                        .groupingBy(Place::getCity, Collectors
                                .mapping(Place::getDistrict, Collectors.toSet())));

        districts.forEach((a, b) -> {
            System.out.println(a);
            b.forEach(d -> System.out.println(" |".concat(d)));
        });

        Boolean askUserForValue = true;
        while (askUserForValue) {
            String parameter = receiveUserInput();
            if (parameter.isEmpty()) {
                return null;
            }
            try {
                return adsList
                        .stream()
                        .map(Place::getDistrict)
                        .filter(d -> d.equalsIgnoreCase(parameter))
                        .findAny()
                        .get();
            } catch (Exception e) {
                System.out.println("Niepoprawna wartość. Wpisz jeszcze raz:");
            }
        }
        return null;
    }

    private Boolean receiveYesOrNo(String message) {
        System.out.println(message + "(tak/nie/ENTER aby pominąć):");
        Boolean askUserForValue = true;
        while (askUserForValue) {
            switch (receiveUserInput().toLowerCase()) {
                case "tak":
                    return true;
                case "nie":
                    return false;
                case "":
                    return null;
                default:
                    System.out.println("Niepoprawna wartość. Wpisz tak lub nie:");
            }
        }
        return null;
    }

    private BigDecimal receiveBigDecimalValue(String message) {
        System.out.println(message + "(ENTER aby pominąć):");
        Boolean askUserForValue = true;
        while (askUserForValue) {
            String parameter = receiveUserInput();
            if (parameter.equals("")) {
                return null;
            }
            try {
                if (Double.parseDouble(parameter) >= 0) {
                    return new BigDecimal(parameter);
                } else System.out.println("Wartość nie może być mniejsza niż 0. Wpisz jeszcze raz: ");
            } catch (Exception e) {
                System.out.println("Niepoprawna wartość. Wpisz jeszcze raz:");
            }
        }
        return null;
    }

    private Double receiveDoubleValue(String message) {
        System.out.println(message + "(ENTER aby pominąć):");
        Boolean askUserForValue = true;
        while (askUserForValue) {
            String parameter = receiveUserInput();
            if (parameter.equals("")) {
                return null;
            }
            try {
                if (Double.parseDouble(parameter) >= 0) {
                    return Double.parseDouble(parameter);
                } else System.out.println("Wartość nie może być mniejsza niż 0. Wpisz jeszcze raz: ");
            } catch (Exception e) {
                System.out.println("Niepoprawna wartość. Wpisz jeszcze raz:");
            }
        }
        return null;
    }

    private Integer receiveIntegerValue(String message) {
        System.out.println(message + "(ENTER aby pominąć):");
        Boolean askUserForValue = true;
        while (askUserForValue) {
            String parameter = receiveUserInput();
            if (parameter.equals("")) {
                return null;
            }
            try {
                if (Integer.parseInt(parameter) >= 0) {
                    return Integer.parseInt(parameter);
                } else System.out.println("Wartość nie może być mniejsza niż 0. Wpisz jeszcze raz: ");
            } catch (Exception e) {
                System.out.println("Niepoprawna wartość. Wpisz jeszcze raz:");
            }
        }
        return null;
    }
}
