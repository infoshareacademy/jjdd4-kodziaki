package com.infoshare.kodziaki;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static java.util.stream.Collectors.joining;

public class AddingAnnouncement {

    public static String readFromUser(String question, List<String> options) {
        Scanner scanner = new Scanner(System.in);
        String input = null;

        System.out.print(question + " (" + options.stream().collect(joining(", ")) + "): ");

        while (true) {
            input = scanner.nextLine();
            if (options.contains(input)) {
                break;
            } else {
                System.out.print("Poprawne wartości to: " + options.stream().collect(joining(", ")) + " - Spróbuj jeszcze raz: " );
            }
        }
        return input;
    }

    public static void adding() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Tytuł ogłoszenia: ");
        String title = null;
        while (true){
            try {
                title = new String(scanner.nextLine());
                break;
            } catch (Exception e){
                System.out.print("Coś poszło nie tak, spróbuj jeszcze raz: ");
            }
        }

        System.out.print("Podaj miasto: ");
        String city = null;
        while (true){
            try {
                city = new String(scanner.nextLine());
                break;
            } catch (Exception e){
                System.out.print("Coś poszło nie tak, spróbuj jeszcze raz: ");
            }
        }

        System.out.print("Podaj dzielnice miasta: ");
        String district = null;
        while (true){
            try{
                district = new String(scanner.nextLine());
                break;
            } catch (Exception e){
                System.out.print("Coś poszło nie tak, spróbuj jeszcze raz: ");
            }
        }

        String placeType = readFromUser("Rodzaj zakwaterowania: ", Arrays.asList("apartment", "room", "bed"));

        System.out.print("Podaj powierzchnię w m kw.: ");
        Double area = null;
        while (true){
            try {
                area = new Double(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.print("Coś poszło nie tak, spróbuj jeszcze raz: ");
            }
        }

        System.out.print("Liczba pokoi: ");
        Integer rooms = null;
        while (true){
            try{
                rooms = new Integer(scanner.nextLine());
                break;
            }catch (Exception e) {
                System.out.print("Coś poszło nie tak, spróbuj jeszcze raz: ");
            }
        }

        System.out.print("Podaj piętro mieszkania: ");
        Integer floor = null;
        while (true){
            try {
                floor = new Integer(scanner.nextLine());
                break;
            }catch (Exception e){
                System.out.print("Coś poszło nie tak, spróbuj jeszcze raz: ");
            }
        }

        String hasElevator = readFromUser("Czy w budynku jest winda?", Arrays.asList("true", "false"));

        String smokingAllowed = readFromUser("Czy palenie w budynku jest doswolone?", Arrays.asList("true", "false"));

        String animalsAllowed = readFromUser("Czy zwierzęta w budynku są dozwolone?", Arrays.asList("true", "false"));

        String onlyLongTerm = readFromUser("Czy preferujesz wynajem długoterminowy", Arrays.asList("true", "false"));

        System.out.print("Cena: ");
        BigDecimal price = null;
        while (true) {
            try {
                price = new BigDecimal(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.print("Coś poszło nie tak, spróbuj jeszcze raz: ");
            }
        }

        System.out.print("Dodatkowy opis mieszkania: ");
        String description = null;
        while (true){
            try{
                description = new String(scanner.nextLine());
                break;
            } catch (Exception e){
                System.out.print("Coś poszło nie tak, spróbuj jeszcze raz: ");
            }
        }

        System.out.print("Podaj swoje imię i nazwisko: ");
        String author = null;
        while (true){
            try {
                author = new String(scanner.nextLine());
                break;
            } catch (Exception e){
                System.out.print("Coś poszło nie tak, spróbuj jeszcze raz: ");
            }
        }

        System.out.print("Podaj numer telefonu: ");
        Integer phoneNumber = null;
        while (true){
            try {
                phoneNumber = new Integer(scanner.nextLine());
                break;
            } catch (Exception e){
                System.out.print("Coś poszło nie tak, spróbuj jeszcze raz: ");
            }
        }

        try {
            Random id = new Random();

            FileWriter file = new FileWriter("/home/mikolajandrzejewski/Projekt Kodziaki/jjdd4-kodziaki/files/ads.csv", true);
            BufferedWriter add = new BufferedWriter(file);
            add.write(id.nextInt() + ";" + title + ";" + placeType + ";" + price + ";" + area + ";" + rooms + ";" + floor + ";" + district + ";" + city + ";" + hasElevator + ";" + smokingAllowed + ";" + animalsAllowed + ";" + onlyLongTerm + ";" + description+ ";" +author+ ";" + phoneNumber);
            add.newLine();
            add.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}

