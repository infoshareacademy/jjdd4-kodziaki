package com.infoshare.kodziaki;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterRepositoryByPreferences {

    public List<Place> filterRepositoryByPreferences(List<Place> adsList, UserPreferences userPrefereces) {

        Stream<Place> adsListStream = adsList.stream();
        adsListStream = filterByPlaceType(adsListStream, userPrefereces);
        adsListStream = filterByPrice(adsListStream, userPrefereces);
        adsListStream = filterByArea(adsListStream, userPrefereces);
        adsListStream = filterByRooms(adsListStream, userPrefereces);
        adsListStream = filterByCity(adsListStream, userPrefereces);
        adsListStream = filterByDistrict(adsListStream, userPrefereces);
        adsListStream = filterByOtherParameters(adsListStream, userPrefereces);

        return adsListStream.collect(Collectors.toList());
    }

    private Stream<Place> filterByPlaceType(Stream<Place> input, UserPreferences userPreferences) {
        if (userPreferences.getPlaceType() != null) {
            return input.filter(p -> p.getPlaceType() == userPreferences.getPlaceType());
        }
        return input;
    }

    private Stream<Place> filterByPrice(Stream<Place> input, UserPreferences userPreferences) {
        if (userPreferences.getMinPrice() != null) {
           return input.filter(p -> p.getPrice().compareTo(userPreferences.getMinPrice()) > 0 );
        }
        if (userPreferences.getMaxPrice() != null) {
            return input.filter(p -> p.getPrice().compareTo(userPreferences.getMaxPrice()) < 0 );
        }
        return input;
    }

    private Stream<Place> filterByArea(Stream<Place> input, UserPreferences userPreferences) {
        if (userPreferences.getMinArea() != null) {
            return input.filter(p -> p.getArea().compareTo(userPreferences.getMinArea()) > 0 );
        }
        if (userPreferences.getMaxPrice() != null) {
            return input.filter(p -> p.getArea().compareTo(userPreferences.getMaxArea()) < 0 );
        }
        return input;
    }

    private Stream<Place> filterByRooms(Stream<Place> input, UserPreferences userPreferences) {
        if (userPreferences.getRooms() != null) {
            return input.filter(p -> p.getRooms() == userPreferences.getRooms());
        }
        return input;
    }

    private Stream<Place> filterByCity(Stream<Place> input, UserPreferences userPreferences) {
        if (userPreferences.getCity() != null) {
            return input.filter(p -> p.getCity().equals(userPreferences.getCity()));
        }
        return input;
    }

    private Stream<Place> filterByDistrict(Stream<Place> input, UserPreferences userPreferences) {
        if (userPreferences.getDistrict() != null) {
            return input.filter(p -> p.getDistrict().equals(userPreferences.getDistrict()));
        }
        return input;
    }

    private Stream<Place> filterByOtherParameters(Stream<Place> input, UserPreferences userPreferences) {
        if (userPreferences.isHasElevator() != null) {
            input = input.filter(p -> p.isHasElevator() == userPreferences.isHasElevator());
        }

        if (userPreferences.isAnimalAllowed() != null) {
            input = input.filter(p -> p.isAnimalAllowed() == userPreferences.isAnimalAllowed());
        }

        if (userPreferences.isSmokingAllowed() != null) {
            input = input.filter(p -> p.isSmokingAllowed() == userPreferences.isSmokingAllowed());
        }

        if (userPreferences.isOnlyLongTerm() != null) {
            input = input.filter(p -> p.isOnlyLongTerm() == userPreferences.isOnlyLongTerm());
        }
        return input;
    }

}
