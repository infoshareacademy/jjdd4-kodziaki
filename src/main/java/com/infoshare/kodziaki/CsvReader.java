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
                .map(array -> new Place(
                        Integer.parseInt(array[0]),
                        array[1],
                        PlaceType.valueOf(array[2]),
                        BigDecimal.valueOf(Double.parseDouble(array[3])),
                        Double.parseDouble(array[4]),
                        Integer.parseInt(array[5]),
                        Integer.parseInt(array[6]),
                        array[7],
                        array[8],
                        Boolean.parseBoolean(array[9]),
                        Boolean.parseBoolean(array[10]),
                        Boolean.parseBoolean(array[11]),
                        Boolean.parseBoolean(array[12]),
                        array[13],
                        array[14],
                        array[15]
                        ))
                .collect(Collectors.toList());
    }
}

