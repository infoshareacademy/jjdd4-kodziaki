package com.infoshare.kodziaki;

import java.io.*;
import java.util.Enumeration;
import java.util.InvalidPropertiesFormatException;

public class Properties {

    public static void readProperties() {

        try {
            File file = new File("conf/application.xml");
            FileInputStream fileInput = new FileInputStream(file);
            java.util.Properties properties = new java.util.Properties();
            properties.loadFromXML(fileInput);
            fileInput.close();

            Enumeration enuKeys = properties.keys();
            while (enuKeys.hasMoreElements()) {
                String key = (String) enuKeys.nextElement();
                String value = properties.getProperty(key);
                System.out.println(key + ": " + value);
            }
        } catch (InvalidPropertiesFormatException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}