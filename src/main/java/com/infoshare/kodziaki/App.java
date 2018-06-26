package com.infoshare.kodziaki;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException{

        AddingAnnouncement ad1 = new AddingAnnouncement();

        ad1.adding();

        //List<Place> list = CsvReader.readFile(new FileReader("files/ads.csv"));
        //list.forEach(System.out::println);
    }
}
