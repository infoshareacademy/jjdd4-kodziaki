package com.infoshare.kodziaki;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.List;

public class App {
    public static void main( String[] args ) throws FileNotFoundException {

        SearchParam searchParam = new SearchParam();
        searchParam.setPlaceType(PlaceType.APARTMENT);
        searchParam.setCity("Gdańsk");
        searchParam.setMinPrice(BigDecimal.valueOf(1000));

        List<Place> list = CsvReader.readFile(new FileReader("files/ads.csv"));
        List<Place> sortedList = SearchRepositoryByParam.searchByParam(list, searchParam);

        sortedList.forEach(p -> System.out.println(p.toString()));
    }
}
