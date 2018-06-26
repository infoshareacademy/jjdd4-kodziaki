package com.infoshare.kodziaki;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import static com.infoshare.kodziaki.ChooseOption.chooseOption;
import static com.infoshare.kodziaki.Menu.mainMenu;

public class App {
    public static void main( String[] args ) throws FileNotFoundException {

        mainMenu();

        chooseOption();

        List<Place> list = CsvReader.readFile(new FileReader("files/ads.csv"));
    }
}