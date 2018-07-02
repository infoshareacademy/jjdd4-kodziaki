package com.infoshare.kodziaki;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;
import java.util.Optional;

public class App {
    public static void main( String[] args ) throws FileNotFoundException {

        Reader reader = new FileReader("./files/ads.csv");
        List<Place> adsList = CsvReader.readFile(reader);

        GetUserPreferences getUserPreferences = new GetUserPreferences();
        UserPreferences userPreferences = getUserPreferences.getUserPreferences(adsList);

        FilterRepositoryByPreferences filterRepositoryByPreferences = new FilterRepositoryByPreferences();
        Optional<List<Place>> adsToDisplay = filterRepositoryByPreferences.filterRepositoryByPreferences(adsList, userPreferences);

        adsToDisplay.ifPresent(places -> places
                .forEach(p -> System.out.println(p.toString())));
    }
}
