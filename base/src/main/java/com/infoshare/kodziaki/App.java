package com.infoshare.kodziaki;

import java.io.FileNotFoundException;

import static com.infoshare.kodziaki.Logo.logo;


public class App {

    public static void main( String[] args ) throws FileNotFoundException {

        Properties.readProperties();

        logo();

        System.out.println("Witaj w appARTMENTS!");
        System.out.println("==============================================");

        Menu.mainMenu();

        ChooseOption.chooseOption();

    }
}