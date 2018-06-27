package com.infoshare.kodziaki;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class ReadProperties {

    Properties properties = new Properties();


    public static void readProperties() throws IOException {

        try {
            File file = new File("conf/application.xml");
            FileInputStream fileInput = new FileInputStream(file);
            Properties properties = new Properties();
            properties.loadFromXML(fileInput);
            fileInput.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void setProperties(){
        Enumeration enuKeys = properties.keys();
            while (enuKeys.hasMoreElements()) {
                String key = (String) enuKeys.nextElement();
                String value = properties.getProperty(key);
                System.out.println(key + ": " + value);
            }


        try {
            Properties properties = new Properties();
            properties.setProperty("favoriteAnimal", "marmot");
            properties.setProperty("favoriteContinent", "Antarctica");
            properties.setProperty("favoritePerson", "Nicole");

            File file = new File("test2.xml");
            FileOutputStream fileOut = new FileOutputStream(file);
            properties.storeToXML(fileOut, "Favorite Things");
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


//          http://www.avajava.com/tutorials/lessons/how-do-i-write-properties-to-an-xml-file.html
//        http://www.avajava.com/tutorials/lessons/how-do-i-write-properties-to-an-xml-file.html


    }
}