package com.infoshare.kodziaki;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvReader {

    public static List<Place> readFile(String filePath) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        List<Place> places = new ArrayList<>();
        String textLine = bufferedReader.readLine();

        do {
            textLine = bufferedReader.readLine();
            String[] array = textLine.split(";"); // coś tu nie gra
            places.add(new Place(
                    Integer.parseInt(array[0]),
                    array[1],
                    placeType.valueOf(array[2]),
                    Double.parseDouble(array[3]),
                    Double.parseDouble(array[4]),
                    Integer.parseInt(array[5]),
                    Integer.parseInt(array[6]),
                    array[7],
                    array[8],
                    Boolean.parseBoolean(array[9]),
                    Boolean.parseBoolean(array[10]),
                    Boolean.parseBoolean(array[11]),
                    Boolean.parseBoolean(array[12]),
                    array[13]));

        } while (textLine != null);

        bufferedReader.close();
        return places;
    }
}


//public class CsvReader<T> {
//
//    private static final String SEPARATOR = ";";
//
//    public List<T> readAll(Reader source, Function<String[], T> mapper) {
//
//        if (source == null) {
//            throw new RuntimeException("source may not be null!");
//        }
//
//        try (BufferedReader reader = new BufferedReader(source)) {
//            return reader.lines()
//                    .map(line -> line.split(SEPARATOR))
//                    .map(mapper)
//                    .collect(Collectors.toList());
//        } catch (IOException e) {
//            throw new UncheckedIOException(e);
//        }
//    }
//}
