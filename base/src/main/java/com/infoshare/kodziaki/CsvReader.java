package com.infoshare.kodziaki;

import javax.enterprise.context.RequestScoped;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class CsvReader {
    private static final String SEPARATOR = ";";

    public List<Place> readFile(Reader source) throws IOException, NumberFormatException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(source);
            return reader.lines()
                    .skip(1)
                    .map(l -> l.split(SEPARATOR))
                    .map(array -> new PlaceBuilder()
                            .withId(Integer.parseInt(array[0]))
                            .withTitle(array[1])
                            .withPlaceType(PlaceType.valueOf(array[2]))
                            .withPrice(BigDecimal.valueOf(Double.parseDouble(array[3])))
                            .withArea(Double.parseDouble(array[4]))
                            .withRooms(Integer.parseInt(array[5]))
                            .withFloor(Integer.parseInt(array[6]))
                            .withDistrict(array[7])
                            .withCity(array[8])
                            .withHasElevator(Boolean.parseBoolean(array[9]))
                            .withSmokingAllowed(Boolean.parseBoolean(array[10]))
                            .withAnimalAllowed(Boolean.parseBoolean(array[11]))
                            .withOnlyLongTerm(Boolean.parseBoolean(array[12]))
                            .withDescription(array[13])
                            .withAuthor(array[14])
                            .withPhoneNumber(array[15])
                            .buildPlace())
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

