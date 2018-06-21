package com.infoshare.kodziaki;

import java.io.IOException;
import java.util.List;

public class App {
    public static void main( String[] args ) throws IOException {

        System.out.println(CsvReader.readFile("/home/martak/workspace/jjdd4-kodziaki/files/ads.csv"));
    }
}
