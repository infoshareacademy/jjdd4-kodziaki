package com.infoshare.kodziaki;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.List;

public class App {
    public static void main( String[] args ) throws FileNotFoundException {

//        SearchParameters searchParameters = new SearchParameters();
//        searchParameters.setPlaceType(PlaceType.APARTMENT);
//        searchParameters.setCity("Gdańsk");
//        searchParameters.setMinPrice(BigDecimal.valueOf(1000));
//
//        List<Place> list = CsvReader.readFile(new FileReader("files/ads.csv"));
//        List<Place> sortedList = SearchRepositoryByParameters.searchByParameters(list, searchParameters);
//
//        sortedList.forEach(p -> System.out.println(p.toString()));

        GetUserPreferences.getUserPreferences();
    }
}
