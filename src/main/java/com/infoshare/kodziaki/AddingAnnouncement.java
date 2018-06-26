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

    public static Double readDoubleFromUser(String question) {
        Double input = null;
        Scanner scanner = new Scanner(System.in);

        System.out.print(question);

        while (true) {
            try {
                input = new Double(scanner.nextLine());
                if (input < 0) {
                    System.out.print("Coś poszło nie tak, spróbuj jeszcze raz: ");
                }
                else {
                    break;
                }
            } catch (Exception e) {
                System.out.print("Coś poszło nie tak, spróbuj jeszcze raz: ");
            }
        }

        return input;
    }

    public static BigDecimal readBigDecimalFromUser(String question) {
        BigDecimal input = null;
        Scanner scanner = new Scanner(System.in);

        System.out.print(question);

        while (true) {
            try {
                input = new BigDecimal(scanner.nextLine());
                if (input.intValue() < 0) {
                    System.out.print("Coś poszło nie tak, spróbuj jeszcze raz: ");
                }
                else {
                    break;
                }
            } catch (Exception e) {
                System.out.print("Coś poszło nie tak, spróbuj jeszcze raz: ");
            }
        }

        return input;
    }

    public static boolean readBooleanFromUser(String question) {

        List<String> options = Arrays.asList("tak", "nie");

        Scanner scanner = new Scanner(System.in);
        String input = null;

        System.out.print(question + " (" + options.stream().collect(joining(", ")) + "): ");

        while (true) {
            input = scanner.nextLine();
            if (options.contains(input)) {
                break;
            } else {
                System.out.print("Poprawne wartości to: " + options.stream().collect(joining(", ")) + " - Spróbuj jeszcze raz: ");
            }
        }

        return input.equals("tak");
    }

    public static String readFromUser(String question, List<String> options) {

        Scanner scanner = new Scanner(System.in);
        String input = null;

        System.out.print(question + " (" + options.stream().collect(joining(", ")) + "): ");

        while (true) {
            input = scanner.nextLine();
            if (options.contains(input)) {
                break;
            } else {
                System.out.print("Poprawne wartości to: " + options.stream().collect(joining(", ")) + " - Spróbuj jeszcze raz: ");
            }
        }
        return input;
    }

    public static Integer readIntegerFromUser(String question) {

        Scanner scanner = new Scanner(System.in);
        Integer input = null;

        System.out.print(question);

        while (true) {
            try {
                input = new Integer(scanner.nextLine());
                if (input < 0) System.out.print("Coś poszło nie tak, spróbuj jeszcze raz: ");
                else break;
            } catch (Exception e) {
                System.out.print("Coś poszło nie tak, spróbuj jeszcze raz: ");
            }
        }
        return input;
    }

        public static void adding () {

            Scanner scanner = new Scanner(System.in);

            System.out.print("Tytuł ogłoszenia: ");
            String title = new String(scanner.nextLine());

            System.out.print("Podaj miasto: ");
            String city = new String(scanner.nextLine());

            System.out.print("Podaj dzielnice miasta: ");
            String district = new String(scanner.nextLine());

            String placeType = readFromUser("Rodzaj zakwaterowania: ", Arrays.asList("mieszkanie", "pokoj", "lozko"));

            Double area = readDoubleFromUser("Powierzchnia: ");

            Integer rooms = readIntegerFromUser("Liczba pokoi: ");

            Integer floor = readIntegerFromUser("Piętro: ");

            boolean hasElevator = readBooleanFromUser("Czy w budynku jest winda?");

            boolean smokingAllowed = readBooleanFromUser("Czy palenie w budynku jest doswolone?");

            boolean animalsAllowed = readBooleanFromUser("Czy zwierzęta w budynku są dozwolone?");

            boolean onlyLongTerm = readBooleanFromUser("Czy preferujesz wynajem długoterminowy");

            BigDecimal price = readBigDecimalFromUser("Cena: ");

            System.out.print("Dodatkowy opis mieszkania: ");
            String description = new String(scanner.nextLine());

            System.out.print("Podaj swoje imię i nazwisko: ");
            String author = new String(scanner.nextLine());

            System.out.print("Podaj numer telefonu: ");
            String phoneNumber = new String(scanner.nextLine());



            try {
                Random id = new Random();

                FileWriter file = new FileWriter("files/ads.csv", true);
                BufferedWriter add = new BufferedWriter(file);
                add.write(id.nextInt() + ";" + title + ";" + placeType + ";" + price + ";" + area + ";" + rooms + ";" + floor + ";" + district + ";" + city + ";" + hasElevator + ";" + smokingAllowed + ";" + animalsAllowed + ";" + onlyLongTerm + ";" + description + ";" + author + ";" + phoneNumber);
                add.newLine();
                add.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }

        }
    }


