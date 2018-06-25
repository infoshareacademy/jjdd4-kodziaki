package com.infoshare.kodziaki;
import java.io.FileReader;
import java.util.List;

import static com.infoshare.kodziaki.ChooseOption.chooseOption;
import static com.infoshare.kodziaki.Menu.mainMenu;

public class App {
    public static void main( String[] args ) {
        List<Place> list = CsvReader.readFile(new FileReader("files/ads.csv"));
        list.forEach(System.out::println);

        mainMenu();

        chooseOption();
    }
}