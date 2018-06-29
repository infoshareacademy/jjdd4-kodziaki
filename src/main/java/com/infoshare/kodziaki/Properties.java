package com.infoshare.kodziaki;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;
import java.util.Map;

public class Properties {

    private static final Object PROPERTY_CURRENCY_KEY = "currency";
    private static final Object PROPERTY_ADSFILEPATH_KEY = "adsFilePath";

    private static Map<String,String> mapWithProperties;

    public static void readProperties() {

        mapWithProperties = new HashMap<>();

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
                mapWithProperties.putIfAbsent(key, value);
            }
        } catch (InvalidPropertiesFormatException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void displayProperties(){
        System.out.println("Ustawienia:");
        System.out.println(PROPERTY_CURRENCY_KEY + " = " + Properties.getCurrency());
        System.out.println(PROPERTY_ADSFILEPATH_KEY + " = " + Properties.getAdsFilePath());
    }

    public static String getCurrency() {
        return mapWithProperties.get(PROPERTY_CURRENCY_KEY);
    }

    public static String getAdsFilePath(){
        return mapWithProperties.get(PROPERTY_ADSFILEPATH_KEY);
    }
}