package com.infoshare.kodziaki.model;

import com.infoshare.kodziaki.model.Place;
import com.infoshare.kodziaki.model.PlaceType;
import com.infoshare.kodziaki.model.UserPreferences;

import javax.ejb.Stateless;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterAdsByPreferences {

    public Optional<List<Place>> filterAdsByPreferences(List<Place> adsList, UserPreferences userPrefereces) {

        Stream<Place> adsListStream = adsList.stream();
        adsListStream = filterByPlaceType(adsListStream, userPrefereces.getPlaceType());
        adsListStream = filterByPrice(adsListStream, userPrefereces);
        adsListStream = filterByArea(adsListStream, userPrefereces);
        adsListStream = filterByRooms(adsListStream, userPrefereces);
        adsListStream = filterByFloors(adsListStream, userPrefereces);
        adsListStream = filterByCity(adsListStream, userPrefereces.getCity());
        adsListStream = filterByDistrict(adsListStream, userPrefereces.getDistrict());
        adsListStream = filterByOtherParameters(adsListStream, userPrefereces);
        adsListStream = filterByOtherParameters(adsListStream, userPrefereces);
        adsListStream = filterByOtherParameters(adsListStream, userPrefereces);
        adsListStream = filterByOtherParameters(adsListStream, userPrefereces);

        try {
            adsList = adsListStream.collect(Collectors.toList());
        } catch (Exception e) {
            return Optional.empty();
        }
        if (adsList.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(adsList);
    }

    private Stream<Place> filterByPlaceType(Stream<Place> input, PlaceType placeType) {
        if (placeType != null) {
            return input.filter(p -> p.getPlaceType() == placeType);
        }
        return input;
    }

    private Stream<Place> filterByPrice(Stream<Place> input, UserPreferences userPreferences) {
        try {
            if (userPreferences.getMinPrice() != null) {
                input = input.filter(p -> p.getPrice().compareTo(userPreferences.getMinPrice()) >= 0);
            }
            if (userPreferences.getMaxPrice() != null) {
                input = input.filter(p -> p.getPrice().compareTo(userPreferences.getMaxPrice()) <= 0);
            }
        } catch (Exception e) {
            return null;
        }
        return input;
    }

    private Stream<Place> filterByArea(Stream<Place> input, UserPreferences userPreferences) {
        try {
            if (userPreferences.getMinArea() != null) {
                input = input.filter(p -> p.getArea() >= userPreferences.getMinArea());
            }
            if (userPreferences.getMaxArea() != null) {
                input = input.filter(p -> p.getArea() <= userPreferences.getMaxArea());
            }
        } catch (Exception e) {
            return null;
        }
        return input;
    }

    private Stream<Place> filterByRooms(Stream<Place> input, UserPreferences userPreferences) {
        try {
            if (userPreferences.getMinRooms() != null) {
                input = input.filter(p -> p.getRooms() >= userPreferences.getMinRooms());
            }
            if (userPreferences.getMaxRooms() != null) {
                input = input.filter(p -> p.getRooms() <= userPreferences.getMaxRooms());
            }
        } catch (Exception e) {
            return null;
        }
        return input;
    }

    private Stream<Place> filterByFloors(Stream<Place> input, UserPreferences userPreferences) {
        try {
            if (userPreferences.getMinFloor() != null) {
                input = input.filter(p -> p.getFloor() >= userPreferences.getMinFloor());
            }
            if (userPreferences.getMaxFloor() != null) {
                input = input.filter(p -> p.getFloor() <= userPreferences.getMaxFloor());
            }
        } catch (Exception e) {
            return null;
        }
        return input;
    }

    private Stream<Place> filterByCity(Stream<Place> input, String city) {
        if (city != null) {
            return input.filter(p -> p.getCity().equals(city));
        }
        return input;
    }

    private Stream<Place> filterByDistrict(Stream<Place> input, String district) {
        if (district != null) {
            return input.filter(p -> p.getDistrict().equals(district));
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
