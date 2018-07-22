package com.infoshare.kodziaki;

import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static com.infoshare.kodziaki.ViewPlaceAds.viewPlaceAds;

public class ChooseOption {

    public static void chooseOption() {

        int option = 0;
        Scanner scannerOption = new Scanner(System.in);
        boolean optionCorrect = false;

        do {
            try {
                option = scannerOption.nextInt();

                if (option >= 0 && option <= 3) {
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
                try {
                    CsvReader csvReader = new CsvReader();
                    List<Place> adsList = csvReader.readFile(new FileReader(Properties.getAdsFilePath()));
                    GetUserPreferences getUserPreferences = new GetUserPreferences();
                    UserPreferences userPreferences = getUserPreferences.getUserPreferences(adsList);

                    FilterAdsByPreferences filterAdsByPreferences = new FilterAdsByPreferences();
                    Optional<List<Place>> filteredAdsList =
                            filterAdsByPreferences.filterAdsByPreferences(adsList, userPreferences);

                    if (filteredAdsList.isPresent()) {
                        viewPlaceAds(filteredAdsList.get());
                    } else {
                        System.out.println("==============================================" +
                                "\nNie znaleźliśmy ogłoszeń o podanych parametrach :(" +
                                "\nZmień opcje wyszukiwania i spróbuj jeszcze raz.");
                    }
                } catch (Exception e) {
                    System.out.println("Błąd odczytu danych - pracujemy nad awarią. Może dodasz w tym czasie jakieś ogłoszenie?");
                }
                Menu.mainMenu();
                chooseOption();
                break;
            case 2:
                AddingAnnouncement newAd = new AddingAnnouncement(Properties.getAdsFilePath());
                newAd.adding();
                Menu.mainMenu();
                chooseOption();
                break;
            case 3:
                Properties.displayProperties();
                Menu.mainMenu();
                chooseOption();
                break;
            case 0:
                System.out.println("PAPArtments!");
                break;
        }
    }
}