package com.infoshare.kodziaki;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CsvReader <T> {
    public static final String SEPARATOR = ";";



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
