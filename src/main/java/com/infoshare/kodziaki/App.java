package com.infoshare.kodziaki;

import java.io.FileNotFoundException;

import static com.infoshare.kodziaki.ChooseOption.chooseOption;
import static com.infoshare.kodziaki.Logo.logo;
import static com.infoshare.kodziaki.Menu.mainMenu;
import static com.infoshare.kodziaki.Properties.readProperties;


public class App {

    public static void main( String[] args ) throws FileNotFoundException {

        readProperties();

        logo();

        System.out.println("Witaj w appARTMENTS!");
        System.out.println("==============================================");

        mainMenu();

        chooseOption();

    }
}