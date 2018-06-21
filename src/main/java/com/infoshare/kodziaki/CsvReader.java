package com.infoshare.kodziaki;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader <T> {

    public static List<Place> readFile(String filePath) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        List<Place> place = new ArrayList<>();
        String textLine;
        
        do {
            textLine = bufferedReader.readLine();
            System.out.println(textLine);
            String[] array = textLine.split(";");

        } while (textLine != null);

        bufferedReader.close();
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
