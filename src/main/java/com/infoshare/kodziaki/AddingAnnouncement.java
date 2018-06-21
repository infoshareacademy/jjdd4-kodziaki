package com.infoshare.kodziaki;


import java.math.BigDecimal;
import java.util.Scanner;

public class AddingAnnouncement {

    public static void adding(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj tytuł ogłoszenia");
        String title= scanner.nextLine();

        System.out.println("Podaj rodzaj zakraterowania: APARTMENT/ROOM/BED");
        String placeType= scanner.nextLine();

        System.out.println("Podaj cene");
        BigDecimal price = new BigDecimal(scanner.nextInt());

        System.out.println("Podaj powierzchnie");
        double area = scanner.nextInt();

        System.out.println("Podaj liczbe pokoi");
        int rooms = scanner.nextInt();

        System.out.println("Podaj piętro mieszkania");
        int floor = scanner.nextInt();

        System.out.println("Podaj dzielnice");
        String district = scanner.nextLine();

        System.out.println("Podaj miasto");
        String miasto = scanner.nextLine();

        System.out.println("Czy w budynku jest winda? (true/false");
        String hasElevator = scanner.nextLine();

        System.out.println("Czy palenie w mieszkaniu jest dozwolone? (true/false)");
        String smokingAllowed = scanner.nextLine();

        System.out.println("Czy dozwolone sa zwierzeta w budynku? (true/false");
        String animalsAllowed = scanner.nextLine();

        System.out.println("Czy wynajem dlugoterminowy? (true/false)");
        String onlyLongTerm = scanner.nextLine();

        System.out.println("Dodaj opis mieszkania");
        String description = scanner.nextLine();
    }

}


