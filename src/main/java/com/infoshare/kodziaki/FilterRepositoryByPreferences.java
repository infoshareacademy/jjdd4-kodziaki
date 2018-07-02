package com.infoshare.kodziaki;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterRepositoryByPreferences {

    List<Place> filterRepositoryByPreferences(List<Place> adsList, UserPreferences userPrefereces) {

        Stream<Place> adsListStream = adsList.stream();
        adsListStream = filterByPlaceType(adsListStream, userPrefereces.getPlaceType());
        adsListStream = filterByMinPrice(adsListStream, userPrefereces.getMinPrice());
//        adsListStream = filterByArea(adsListStream, userPrefereces);
//        adsListStream = filterByRooms(adsListStream, userPrefereces);
//        adsListStream = filterByFloors(adsListStream, userPrefereces);
//        adsListStream = filterByCity(adsListStream, userPrefereces);
//        adsListStream = filterByDistrict(adsListStream, userPrefereces);
//        adsListStream = filterByOtherParameters(adsListStream, userPrefereces);

        return adsListStream.collect(Collectors.toList());
    }

    private Stream<Place> filterByPlaceType(Stream<Place> input, PlaceType placeType) {
        if (placeType != null) {
            return input.filter(p -> p.getPlaceType() == placeType);
        }
        return input;
    }

    private Stream<Place> filterByMinPrice(Stream<Place> input, BigDecimal minPrice) {
        if (minPrice != null) {
           input.filter(p -> p.getPrice().compareTo(minPrice) > 0 );
        }
        return input;
    }

    private Stream<Place> filterByMaxPrice(Stream<Place> input, BigDecimal maxPrice) {
        if (maxPrice != null) {
            input.filter(p -> p.getPrice().compareTo(maxPrice) > 0 );
        }
        return input;
    }
//
//    private Stream<Place> filterByArea(Stream<Place> input, UserPreferences userPreferences) {
//        if (userPreferences.getMinArea() != null) {
//            return input.filter(p -> p.getArea().compareTo(userPreferences.getMinArea()) > 0 );
//        }
//        if (userPreferences.getMaxPrice() != null) {
//            return input.filter(p -> p.getArea().compareTo(userPreferences.getMaxArea()) < 0 );
//        }
//        return input;
//    }
//
//    private Stream<Place> filterByRooms(Stream<Place> input, UserPreferences userPreferences) {
//        if (userPreferences.getMinRooms() != null) {
//            return input.filter(p -> p.getRooms() > userPreferences.getMinRooms());
//        }
//        if (userPreferences.getMaxRooms() != null) {
//            return input.filter(p -> p.getRooms() < userPreferences.getMaxRooms());
//        }
//        return input;
//    }
//
//    private Stream<Place> filterByFloors(Stream<Place> input, UserPreferences userPreferences) {
//        if (userPreferences.getMinFloor() != null) {
//            return input.filter(p -> p.getFloor() > userPreferences.getMinFloor());
//        }
//        if (userPreferences.getMaxFloor() != null) {
//            return input.filter(p -> p.getRooms() < userPreferences.getMaxFloor());
//        }
//        return input;
//    }
//
//    private Stream<Place> filterByCity(Stream<Place> input, UserPreferences userPreferences) {
//        if (userPreferences.getCity() != null) {
//            return input.filter(p -> p.getCity().equals(userPreferences.getCity()));
//        }
//        return input;
//    }
//
//    private Stream<Place> filterByDistrict(Stream<Place> input, UserPreferences userPreferences) {
//        if (userPreferences.getDistrict() != null) {
//            return input.filter(p -> p.getDistrict().equals(userPreferences.getDistrict()));
//        }
//        return input;
//    }
//
//    private Stream<Place> filterByOtherParameters(Stream<Place> input, UserPreferences userPreferences) {
//        if (userPreferences.isHasElevator() != null) {
//            input = input.filter(p -> p.isHasElevator() == userPreferences.isHasElevator());
//        }
//
//        if (userPreferences.isAnimalAllowed() != null) {
//            input = input.filter(p -> p.isAnimalAllowed() == userPreferences.isAnimalAllowed());
//        }
//
//        if (userPreferences.isSmokingAllowed() != null) {
//            input = input.filter(p -> p.isSmokingAllowed() == userPreferences.isSmokingAllowed());
//        }
//
//        if (userPreferences.isOnlyLongTerm() != null) {
//            input = input.filter(p -> p.isOnlyLongTerm() == userPreferences.isOnlyLongTerm());
//        }
//        return input;
    }
