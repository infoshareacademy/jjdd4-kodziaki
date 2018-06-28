package com.infoshare.kodziaki;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static com.infoshare.kodziaki.AddPlaceAds.addPlaceAds;
import static com.infoshare.kodziaki.ViewPlaceAds.viewPlaceAds;




public class ChooseOption {

    public static void main( String[] args ) throws FileNotFoundException {
        List<Place> list = CsvReader.readFile(new FileReader("files/ads.csv"));

        int option = 0;
        Scanner scannerOption = new Scanner(System.in);
        boolean optionCorrect = false;

        do {
            try {
                option = scannerOption.nextInt();

                if (option >= 0 && option <= 2){
                    optionCorrect = true;
                    break;
                } else {
                    System.out.println("Oj! Zły format. Wybierz 1 lub 2");
                }
            } catch (InputMismatchException e) {
                System.out.println("Oj! Zły format. Wybierz 1 lub 2");
                scannerOption.nextLine();
            }
        } while (!optionCorrect);


        switch (option) {
            case 1:
                viewPlaceAds(list);
                break;
            case 2:
                addPlaceAds();
                break;
            case 0:
                System.out.println("PAPArtments! Sija!");
                break;
        }
    }
}