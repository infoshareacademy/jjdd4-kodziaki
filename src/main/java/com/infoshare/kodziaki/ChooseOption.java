package com.infoshare.kodziaki;

import java.util.Scanner;

import static Place.AddPlaceAds.addPlaceAds;
import static Place.ViewPlaceAds.viewPlaceAds;

public class ChooseOption {

    public static void chooseOption() {

        Scanner scannerOption = new Scanner(System.in);
        int option = scannerOption.nextInt();

        while (option < 0 || option > 2) {
            System.out.println("Ups! Niepoprawny wybór :( Wybierz opcję 1 lub 2");
            option = scannerOption.nextInt();
        }

        switch (option) {
            case 1:
                viewPlaceAds();
                break;
            case 2:
                addPlaceAds();
                break;
            case 0:
                System.out.println("Do zobaczenia!");
                break;
        }
    }
}