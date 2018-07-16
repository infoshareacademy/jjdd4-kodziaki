package com.infoshare.kodziaki.dao;

import com.infoshare.kodziaki.model.Place;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PlaceDao {

    @PersistenceContext
    private EntityManager entityManager;

    public int save(Place place) {
        entityManager.persist(place);
        return place.getId();
    }
}
