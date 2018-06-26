package com.infoshare.kodziaki;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SearchRepositoryByParamTest {

    @Test
    void searchesByType() {
        Place p1 = new PlaceBuilder().setPlaceType(PlaceType.APARTMENT).createPlace();
        Place p2 = new PlaceBuilder().setPlaceType(PlaceType.ROOM).createPlace();
        Place p3 = new PlaceBuilder().setPlaceType(PlaceType.APARTMENT).createPlace();

        List<Place> list = Arrays.asList(p1, p2, p3);
        SearchParam searchParam = new SearchParam();
        searchParam.setPlaceType(PlaceType.ROOM);
        List<Place> places = SearchRepositoryByParam.searchByParam(list, searchParam);

        assertThat(places).hasSize(1);
    }
}