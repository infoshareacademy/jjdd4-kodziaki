package com.infoshare.kodziaki;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class App {
    public static void main( String[] args ) throws FileNotFoundException {
        List<Place> list = CsvReader.readFile(new FileReader("files/ads.csv"));
        list.forEach(System.out::println);
    }
}
