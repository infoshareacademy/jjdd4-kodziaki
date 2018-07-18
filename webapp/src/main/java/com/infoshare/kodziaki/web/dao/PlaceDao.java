package com.infoshare.kodziaki.web.dao;

import com.infoshare.kodziaki.model.Place;
import com.infoshare.kodziaki.model.UserPreferences;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class PlaceDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveAd(Place place) {
        entityManager.persist(place);
    }

    public List<Place> getAdsFilteredBy(UserPreferences pref) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Place> criteriaQuery = criteriaBuilder.createQuery(Place.class);
        Root<Place> root = criteriaQuery.from(Place.class);
        List<Predicate> predicates = new ArrayList<>();
        
        if (pref.getPlaceType() != null) {
            predicates.add(criteriaBuilder.equal(root.get("placeType"), pref.getPlaceType()));
        }

        if (pref.getCity() != null) {
            predicates.add(criteriaBuilder.equal(root.get("city"), pref.getCity()));
        }

        if (pref.getDistrict() != null) {
            predicates.add(criteriaBuilder.equal(root.get("district"), pref.getDistrict()));
        }

        if (pref.getMinPrice() != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("price"), pref.getMinPrice()));
        }
        
        if (pref.getMaxPrice() != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("price"), pref.getMaxPrice()));
        }

        if (pref.getMinArea() != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("area"), pref.getMinArea()));
        }

        if (pref.getMaxArea() != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("area"), pref.getMaxArea()));
        }

        if (pref.getMinFloor() != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("floor"), pref.getMinFloor()));
        }

        if (pref.getMaxFloor() != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("floor"), pref.getMaxFloor()));
        }

        if (pref.getMinRooms() != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("rooms"), pref.getMinRooms()));
        }

        if (pref.getMaxRooms() != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("rooms"), pref.getMaxRooms()));
        }

        if (pref.isAnimalAllowed() != null) {
            predicates.add(criteriaBuilder.equal(root.get("animalAllowed"), pref.isAnimalAllowed()));
        }

        if (pref.isSmokingAllowed() != null) {
            predicates.add(criteriaBuilder.equal(root.get("smokingAllowed"), pref.isSmokingAllowed()));
        }

        if (pref.isHasElevator() != null) {
            predicates.add(criteriaBuilder.equal(root.get("hasElevator"), pref.isHasElevator()));
        }

        if (pref.isOnlyLongTerm() != null) {
            predicates.add(criteriaBuilder.equal(root.get("onlyLongTerm"), pref.isOnlyLongTerm()));
        }

        criteriaQuery.where(predicates.toArray(new Predicate[]{}));
        Query query = entityManager.createQuery(criteriaQuery);
        return (List<Place>) query.getResultList();
    }

}
