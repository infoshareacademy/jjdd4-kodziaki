package com.infoshare.kodziaki;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchRepositoryByParam {
    public static List<Place> searchByParam(List<Place> list, SearchParam searchParam) {

        Stream<Place> s = list.stream();

        if (searchParam.getPlaceType() != null) {
            s = s.filter(p -> p.getPlaceType() == searchParam.getPlaceType());
        }

        if (searchParam.getMinPrice() != null) {
            s = s.filter(p -> p.getPrice().compareTo(searchParam.getMinPrice()) > 0 );
        }

        if (searchParam.getMaxPrice() != null) {
            s = s.filter(p -> p.getPrice().compareTo(searchParam.getMaxPrice()) < 0 );
        }

        if (searchParam.getMinArea() != null) {
            s = s.filter(p -> p.getArea().compareTo(searchParam.getMinArea()) > 0 );
        }

        if (searchParam.getMaxArea() != null) {
            s = s.filter(p -> p.getArea().compareTo(searchParam.getMaxArea()) < 0 );
        }

        if (searchParam.getRooms() != null) {
            s = s.filter(p -> p.getRooms() == searchParam.getRooms());
        }

        if (searchParam.getCity() != null) {
            s = s.filter(p -> p.getCity().equals(searchParam.getCity()));
        }

        if (searchParam.getDistrict() != null) {
            s = s.filter(p -> p.getDistrict().equals(searchParam.getDistrict()));
        }

        if (searchParam.isHasElevator() != null) {
            s = s.filter(p -> p.isHasElevator() == searchParam.isHasElevator());
        }

        if (searchParam.isAnimalAllowed() != null) {
            s = s.filter(p -> p.isAnimalAllowed() == searchParam.isAnimalAllowed());
        }

        if (searchParam.isSmokingAllowed() != null) {
            s = s.filter(p -> p.isSmokingAllowed() == searchParam.isSmokingAllowed());
        }

        if (searchParam.isOnlyLongTerm() != null) {
            s = s.filter(p -> p.isOnlyLongTerm() == searchParam.isOnlyLongTerm());
        }

        return s.collect(Collectors.toList());
    }
}
