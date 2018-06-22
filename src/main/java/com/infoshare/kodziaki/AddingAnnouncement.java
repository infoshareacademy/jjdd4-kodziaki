package com.infoshare.kodziaki;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.Scanner;

public class AddingAnnouncement {

    public static void adding() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj tytuł ogłoszenia");
        String title = scanner.nextLine();

        System.out.println("Podaj rodzaj zakraterowania: apartment/room/bed");
        String placeType=null;
        boolean isOk = false;
        while(!isOk) {
            placeType = scanner.nextLine();
            if("apartment".equals(placeType) ||"room".equals(placeType) || "bed".equals(placeType)) {
                isOk = true;
            } else {
                System.out.println("Blad, sprobuj jeszcze raz");
            }
        }

        System.out.println("Podaj cene");
        BigDecimal price = scanner.nextBigDecimal();

        System.out.println("Podaj powierzchnie w m kw.");
        double area = scanner.nextDouble();

        System.out.println("Podaj liczbe pokoi");
        int rooms = scanner.nextInt();

        System.out.println("Podaj piętro mieszkania");
        int floor = scanner.nextInt();

        Scanner scanner1 = new Scanner(System.in);

        System.out.println("Podaj dzielnice miasta");
        String district = scanner1.nextLine();

        System.out.println("Podaj miasto");
        String city = scanner1.nextLine();

        System.out.println("Czy w budynku jest winda? (true/false)");
        String hasElevator=null;
        boolean isOk1 = false;
        while(!isOk1) {
            hasElevator = scanner1.nextLine();
            if("true".equals(hasElevator) ||"false".equals(hasElevator)) {
                isOk1 = true;
            } else {
                System.out.println("Blad, sprobuj jeszcze raz");
            }
        }

        System.out.println("Czy palenie w mieszkaniu jest dozwolone? (true/false)");
        String smokingAllowed=null;
        boolean isOk2 = false;
        while(!isOk2) {
            smokingAllowed = scanner1.nextLine();
            if("true".equals(smokingAllowed) ||"false".equals(smokingAllowed)) {
                isOk2 = true;
            } else {
                System.out.println("Blad, sprobuj jeszcze raz");
            }
        }

        System.out.println("Czy dozwolone sa zwierzeta w budynku? (true/false)");
        String animalsAllowed=null;
        boolean isOk3 = false;
        while(!isOk3) {
            animalsAllowed = scanner1.nextLine();
            if("true".equals(animalsAllowed) ||"false".equals(animalsAllowed)) {
                isOk3 = true;
            } else {
                System.out.println("Blad, sprobuj jeszcze raz");
            }
        }

        System.out.println("Czy wynajem dlugoterminowy? (true/false)");
        String onlyLongTerm=null;
        boolean isOk4 = false;
        while(!isOk4) {
            onlyLongTerm = scanner1.nextLine();
            if("true".equals(onlyLongTerm) ||"false".equals(onlyLongTerm)) {
                isOk4 = true;
            } else {
                System.out.println("Blad, sprobuj jeszcze raz");
            }
        }

        System.out.println("Dodaj opis mieszkania");
        String description = scanner1.nextLine();

        try {

            double id = Math.random();

            FileWriter file = new FileWriter("/home/mikolajandrzejewski/Projekt Kodziaki/jjdd4-kodziaki/files/ads.csv", true);
            BufferedWriter add = new BufferedWriter(file);
            add.write(id + ";" + title + ";" + placeType + ";" + price + ";" + area + ";" + rooms + ";" + floor + ";" + district + ";" + city + ";" + hasElevator + ";" + smokingAllowed + ";" + animalsAllowed + ";" + onlyLongTerm + ";" + description);
            add.newLine();
            add.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}

