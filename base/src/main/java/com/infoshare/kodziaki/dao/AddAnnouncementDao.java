package com.infoshare.kodziaki.dao;

import com.infoshare.kodziaki.model.Place;
import com.infoshare.kodziaki.model.Properties;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

import static java.util.stream.Collectors.joining;

@Stateless
public class AddAnnouncementDao {

    @PersistenceContext
    private EntityManager entityManager;

    public int save(Place place) {
        entityManager.persist(place);
        return place.getId();

    }
}
