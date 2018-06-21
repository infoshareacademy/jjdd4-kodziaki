package com.infoshare.kodziaki;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public class AddingAnnouncement {

    public static void adding() throws IOException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj tytuł ogłoszenia");
        String title= scanner.nextLine();

        System.out.println("Podaj rodzaj zakraterowania: APARTMENT/ROOM/BED");
        String placeType= scanner.nextLine();

        System.out.println("Podaj cene");
        BigDecimal price = new BigDecimal(scanner.nextInt());

        System.out.println("Podaj powierzchnie w m kw.");
        double area = scanner.nextInt();

        System.out.println("Podaj liczbe pokoi");
        int rooms = scanner.nextInt();

        System.out.println("Podaj piętro mieszkania");
        int floor = scanner.nextInt();

        Scanner scanner1 = new Scanner(System.in);

        System.out.println("Podaj dzielnice miasta");
        String district = scanner1.nextLine();

        System.out.println("Podaj miasto");
        String city= scanner1.nextLine();

        System.out.println("Czy w budynku jest winda? (true/false)");
        String hasElevator = scanner1.nextLine();

        System.out.println("Czy palenie w mieszkaniu jest dozwolone? (true/false)");
        String smokingAllowed = scanner1.nextLine();

        System.out.println("Czy dozwolone sa zwierzeta w budynku? (true/false)");
        String animalsAllowed = scanner1.nextLine();

        System.out.println("Czy wynajem dlugoterminowy? (true/false)");
        String onlyLongTerm = scanner1.nextLine();

        System.out.println("Dodaj opis mieszkania");
        String description = scanner1.nextLine();

        try {


            FileWriter file = new FileWriter("/home/mikolaj/ProjektKodziaki/jjdd4-kodziaki/files/ads.csv", true);
            BufferedWriter add = new BufferedWriter(file);
            add.write("100" + ";" + title + ";" + placeType + ";" + price + ";" + area + ";" + rooms + ";" + floor + ";" + district + ";" + city + ";" + hasElevator + ";" + smokingAllowed + ";" + animalsAllowed + ";" + onlyLongTerm + ";" + description + "\n");
            add.newLine();
            add.close();

        } catch (Exception e){
            System.out.println("Blad");
        }

    }

}


