package com.infoshare.kodziaki;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;

public class App {
    public static void main( String[] args ) throws FileNotFoundException {

        Reader reader = new FileReader("./files/ads.csv");
        List<Place> adsList = CsvReader.readFile(reader);

        GetUserPreferences getUserPreferences = new GetUserPreferences();
        UserPreferences userPreferences = getUserPreferences.getUserPreferences();

        FilterRepositoryByPreferences filterRepositoryByPreferences = new FilterRepositoryByPreferences();
        List<Place> adsToDisplay = filterRepositoryByPreferences.filterRepositoryByPreferences(adsList, userPreferences);

        adsToDisplay.forEach(ads -> System.out.println(ads.toString()));
    }
}
