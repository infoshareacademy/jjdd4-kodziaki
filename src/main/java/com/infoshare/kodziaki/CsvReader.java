package com.infoshare.kodziaki;

import java.io.BufferedReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class CsvReader {
    private static final String SEPARATOR = ";";

    public static List<Place> readFile(Reader source) {
        if (source == null) {
            throw new RuntimeException("file path is wrong");
        }

        BufferedReader reader = new BufferedReader(source);
        return reader.lines()
                .skip(1)
                .map(l -> l.split(SEPARATOR))
                .map(array -> new PlaceBuilder()
                        .setId(Integer.parseInt(array[0]))
                        .setTitle(array[1])
                        .setPlaceType(PlaceType.valueOf(array[2]))
                        .setPrice(BigDecimal.valueOf(Double.parseDouble(array[3])))
                        .setArea(BigDecimal.valueOf(Double.parseDouble(array[4])))
                        .setRooms(Integer.parseInt(array[5]))
                        .setFloor(Integer.parseInt(array[6]))
                        .setDistrict(array[7])
                        .setCity(array[8])
                        .setHasElevator(Boolean.parseBoolean(array[9]))
                        .setSmokingAllowed(Boolean.parseBoolean(array[10]))
                        .setAnimalAllowed(Boolean.parseBoolean(array[11]))
                        .setOnlyLongTerm(Boolean.parseBoolean(array[12]))
                        .setDescription(array[13]).setAuthor(array[14])
                        .setPhoneNumber(array[15]).createPlace())
                .collect(Collectors.toList());
    }
}

