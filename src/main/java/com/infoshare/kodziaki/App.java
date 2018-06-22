package com.infoshare.kodziaki;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main( String[] args ) throws IOException {

        List<Place> list = CsvReader.readFile(new FileReader("files/ads.csv"));
        System.out.println(list);

    }
}
