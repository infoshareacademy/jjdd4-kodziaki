package com.infoshare.kodziaki.web.dao;

import com.infoshare.kodziaki.model.Place;
import com.infoshare.kodziaki.model.UserPreferences;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class PlaceDao {

    @PersistenceContext
    private EntityManager entityManager;

    public int save(Place place) {
        entityManager.persist(place);
        return place.getId();
    }

    public List<Place> find(UserPreferences p) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Place> criteriaQuery = criteriaBuilder.createQuery(Place.class);
        Root<Place> root = criteriaQuery.from(Place.class);
        List<Predicate> predicates = new ArrayList<>();

        if (p.isAnimalAllowed() != null) {
            predicates.add(criteriaBuilder.equal(root.get("animalAllowed"), p.isAnimalAllowed()));
        }

        if (p.getMaxArea() != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("area"), p.getMaxArea()));
        }

        predicates.add(criteriaBuilder.greaterThan(root.get("price"), 700));

        criteriaQuery.where(predicates.toArray(new Predicate[]{}));
        Query query = entityManager.createQuery(criteriaQuery);
        return (List<Place>) query.getResultList();
    }

}
