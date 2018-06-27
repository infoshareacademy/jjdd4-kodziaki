package com.infoshare.kodziaki;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchRepositoryByParameters {

    private static Stream<Place> filterByPlaceType(Stream<Place> input, SearchParameters searchParameters) {
        if (searchParameters.getPlaceType() != null) {
            return input.filter(p -> p.getPlaceType() == searchParameters.getPlaceType());
        }
        return input;
    }

    private static Stream<Place> filterByPrice(Stream<Place> input, SearchParameters searchParameters) {
        if (searchParameters.getMinPrice() != null) {
           return input.filter(p -> p.getPrice().compareTo(searchParameters.getMinPrice()) > 0 );
        }
        if (searchParameters.getMaxPrice() != null) {
            return input.filter(p -> p.getPrice().compareTo(searchParameters.getMaxPrice()) < 0 );
        }
        return input;
    }

    private static Stream<Place> filterByArea(Stream<Place> input, SearchParameters searchParameters) {
        if (searchParameters.getMinArea() != null) {
            return input.filter(p -> p.getArea().compareTo(searchParameters.getMinArea()) > 0 );
        }
        if (searchParameters.getMaxPrice() != null) {
            return input.filter(p -> p.getArea().compareTo(searchParameters.getMaxArea()) < 0 );
        }
        return input;
    }

    private static Stream<Place> filterByRooms(Stream<Place> input, SearchParameters searchParameters) {
        if (searchParameters.getRooms() != null) {
            return input.filter(p -> p.getRooms() == searchParameters.getRooms());
        }
        return input;
    }

    private static Stream<Place> filterByCity(Stream<Place> input, SearchParameters searchParameters) {
        if (searchParameters.getCity() != null) {
            return input.filter(p -> p.getCity().equals(searchParameters.getCity()));
        }
        return input;
    }

    private static Stream<Place> filterByDistrict(Stream<Place> input, SearchParameters searchParameters) {
        if (searchParameters.getDistrict() != null) {
            return input.filter(p -> p.getDistrict().equals(searchParameters.getDistrict()));
        }
        return input;
    }

    private static Stream<Place> filterByOtherParameters(Stream<Place> input, SearchParameters searchParameters) {
        if (searchParameters.isHasElevator() != null) {
            input = input.filter(p -> p.isHasElevator() == searchParameters.isHasElevator());
        }

        if (searchParameters.isAnimalAllowed() != null) {
            input = input.filter(p -> p.isAnimalAllowed() == searchParameters.isAnimalAllowed());
        }

        if (searchParameters.isSmokingAllowed() != null) {
            input = input.filter(p -> p.isSmokingAllowed() == searchParameters.isSmokingAllowed());
        }

        if (searchParameters.isOnlyLongTerm() != null) {
            input = input.filter(p -> p.isOnlyLongTerm() == searchParameters.isOnlyLongTerm());
        }
        return input;
    }


    public static List<Place> searchByParameters(List<Place> list, SearchParameters searchParameters) {

        Stream<Place> s = list.stream();
        s = filterByPlaceType(s, searchParameters);
        s = filterByPrice(s, searchParameters);
        s = filterByArea(s, searchParameters);
        s = filterByRooms(s, searchParameters);
        s = filterByCity(s, searchParameters);
        s = filterByDistrict(s, searchParameters);
        s = filterByOtherParameters(s, searchParameters);

        return s.collect(Collectors.toList());
    }
}
