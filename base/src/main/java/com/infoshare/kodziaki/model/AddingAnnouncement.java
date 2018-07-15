package com.infoshare.kodziaki.model;

import javax.ejb.Stateless;
import java.io.*;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.joining;

public class AddingAnnouncement {

    private String filePath;

    public AddingAnnouncement(String filepath) {

        this.filePath = filepath;

    }

    public Double readDoubleFromUser(String question) {
        Double input = null;
        Scanner scanner = new Scanner(System.in);

        System.out.print(question);

        while (true) {
            try {
                input = new Double(scanner.nextLine());
                if (input < 0) {
                    System.out.print("Coś poszło nie tak, spróbuj jeszcze raz: ");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.print("Coś poszło nie tak, spróbuj jeszcze raz: ");
            }
        }

        return input;
    }
    
    public String readStringFromUser(String question){
        String input = null;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println(question);
        
        while (true){
            try {
                input = new String(scanner.nextLine());
                if (input.isEmpty()){
                    System.out.println("Coś poszło nie tak, spróbuj jeszcze raz: ");
                } else {
                    break;
                }
            } catch (Exception e) {
                    System.out.print("Coś poszło nie tak, spróbuj jeszcze raz: ");
            }
        }
        
        return input;
    }

    public BigDecimal readBigDecimalFromUser(String question) {
        BigDecimal input = null;
        Scanner scanner = new Scanner(System.in);

        System.out.print(question);

        while (true) {
            try {
                input = new BigDecimal(scanner.nextLine());
                if (input.intValue() < 0) {
                    System.out.print("Coś poszło nie tak, spróbuj jeszcze raz: ");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.print("Coś poszło nie tak, spróbuj jeszcze raz: ");
            }
        }

        return input;
    }

    public boolean readBooleanFromUser(String question) {

        List<String> options = Arrays.asList("TAK", "NIE");

        Scanner scanner = new Scanner(System.in);
        String input = null;

        System.out.print(question + " (" + options.stream().collect(joining(", ")) + "): ");

        while (true) {
            input = scanner.nextLine();
            if (options.contains(input.toUpperCase())) {
                break;
            } else {
                System.out.print("Poprawne wartości to: " + options.stream().collect(joining(", ")) + " - Spróbuj jeszcze raz: ");
            }
        }

        return input.equalsIgnoreCase("tak");
    }

    public String readOptionsFromUser(String question, List<String> options) {

        Scanner scanner = new Scanner(System.in);
        String input = null;

        System.out.print(question + " (" + options.stream().collect(joining(", ")) + "): ");

        while (true) {
            input = scanner.nextLine();
            if (options.contains(input.toUpperCase())) {
                break;
            } else {
                System.out.print("Poprawne wartości to: " + options.stream().collect(joining(", ")) + " - Spróbuj jeszcze raz: ");
            }
        }
        return input;
    }

    public Integer readIntegerFromUser(String question) {

        Scanner scanner = new Scanner(System.in);
        Integer input = null;

        System.out.print(question);

        while (true) {
            try {
                input = new Integer(scanner.nextLine());
                if (input <= 0) System.out.print("Coś poszło nie tak, spróbuj jeszcze raz: ");
                else break;
            } catch (Exception e) {
                System.out.print("Coś poszło nie tak, spróbuj jeszcze raz: ");
            }
        }
        return input;
    }

    public Long getId() {

        Long id = null;

        try {
            FileReader file = new FileReader(filePath);
            BufferedReader countLines = new BufferedReader(file);
            id = countLines.lines().count();
        } catch (Exception e) {
            e.getLocalizedMessage();
        }
        return id;
    }


    public void saving(List<Object> list) {

        try {
            FileWriter file1 = new FileWriter(filePath, true);
            BufferedWriter add = new BufferedWriter(file1);
            add.newLine();
            add.write(list.stream().map(Object::toString).collect(joining(";")));
            add.close();
        } catch (Exception e) {
            e.getLocalizedMessage();
        }
    }


    public void adding() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n"
                + "\n=============================================="
                + "\nPodaj parametry ogłoszenia."
                + "\n==============================================");
        
        String title = readStringFromUser("Tytuł ogłoszenia: ");
        
        String city = readStringFromUser("Podaj miasto: ");
        
        String district = ("Podaj dzielnice miasta: ");

        PlaceType placeType = PlaceType.fromPolishString(readOptionsFromUser("Rodzaj zakwaterowania: ", Arrays.asList("MIESZKANIE", "POKÓJ", "ŁÓŻKO")));

        Double area = readDoubleFromUser("Powierzchnia (w m2): ");

        Integer rooms = readIntegerFromUser("Liczba pokoi: ");

        Integer floor = readIntegerFromUser("Piętro: ");

        boolean hasElevator = readBooleanFromUser("Czy w budynku jest winda?");

        boolean smokingAllowed = readBooleanFromUser("Czy palenie w mieszkaniu jest dozwolone?");

        boolean animalsAllowed = readBooleanFromUser("Czy zwierzęta w mieszkaniu są dozwolone?");

        boolean onlyLongTerm = readBooleanFromUser("Czy preferujesz wynajem długoterminowy");

        BigDecimal price = readBigDecimalFromUser("Cena (" + Properties.getCurrency() + "):");

        String description = readStringFromUser("Dodatkowy opis mieszkania: ");
        
        String author = readStringFromUser("Podaj swoje imię i nazwisko: ");

        String contact = readStringFromUser("Zostaw swojego maila lub numer telefonu: ");


        long id = getId();

        List<Object> list = Arrays.asList(id, title, placeType, price, area, rooms, floor, district, city, hasElevator, smokingAllowed, animalsAllowed, onlyLongTerm, description, author, contact);

        saving(list);

        System.out.println("==============================================");
        System.out.println("Ogłoszenie dodane!");

    }

}



