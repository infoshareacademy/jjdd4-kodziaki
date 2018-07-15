package com.infoshare.kodziaki.model;

import java.io.FileNotFoundException;

import static com.infoshare.kodziaki.model.ChooseOption.chooseOption;
import static com.infoshare.kodziaki.model.Logo.logo;
import static com.infoshare.kodziaki.model.Menu.mainMenu;
import static com.infoshare.kodziaki.model.Properties.readProperties;


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