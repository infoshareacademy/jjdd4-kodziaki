package com.infoshare.kodziaki;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.List;

import static com.infoshare.kodziaki.ChooseOption.chooseOption;
import static com.infoshare.kodziaki.Menu.mainMenu;
import static com.infoshare.kodziaki.ReadProperties.readProperties;


public class App {
    public static void main( String[] args ) throws IOException {

        readProperties();

        List<Place> list = CsvReader.readFile(new FileReader("files/ads.csv"));

        mainMenu();

        chooseOption();

    }
}