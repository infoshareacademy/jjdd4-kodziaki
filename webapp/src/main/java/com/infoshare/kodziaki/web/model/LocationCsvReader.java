package com.infoshare.kodziaki.web.model;

import javax.enterprise.context.RequestScoped;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RequestScoped
public class LocationCsvReader {

    private static final String SEPARATOR = ",";


    public List<Location> readFile(Reader source) throws IOException, NumberFormatException {
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(source);
            return reader.lines()
                    .skip(1)
                    .map(l -> l.split(SEPARATOR))
                    .map(array -> new Location(
                            Long.valueOf(array[0]),
                            array[1],
                            array[2]))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new NumberFormatException();
        } finally {
            if (source != null) {
                reader.close();



            }
        }
    }
}
