package com.infoshare.kodziaki.web.dao;

import com.infoshare.kodziaki.Place;
import com.infoshare.kodziaki.UserPreferences;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
import java.util.Queue;
import java.util.Random;

@Stateless
public class PlaceDao {

    private Logger LOG = LoggerFactory.getLogger(PlaceDao.class);

    @PersistenceContext
    private EntityManager entityManager;

    public void saveAd(Place place) {
        entityManager.persist(place);
    }

    public List<Place> getAllAds() {
        final Query query = entityManager.createQuery("SELECT p FROM Place p");
        return (List<Place>) query.getResultList();
    }

    public Place findById(int id) {
        return entityManager.find(Place.class, id);
    }

    public void delete(int id) {
        final Place place = entityManager.find(Place.class, id);
        if (place != null) {
            entityManager.remove(place);
        }
    }

    public List<Place> getXAds(int x) {
        final Query query = entityManager.createQuery("SELECT p FROM Place p");
        return (List<Place>) query.setMaxResults(x).getResultList();
    }

    public Place update(Place place) {
        return entityManager.merge(place);
    }

    public List<Place> getAdsByUserPreferences(UserPreferences pref) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Place> criteriaQuery = criteriaBuilder.createQuery(Place.class);
        Root<Place> root = criteriaQuery.from(Place.class);
        List<Predicate> predicates = new ArrayList<>();

        if (pref.getPlaceType() != null) {
            predicates.add(criteriaBuilder.equal(root.get("placeType"), pref.getPlaceType()));
            LOG.info("sorted by parameter: placeType");
        }

        if (pref.getCity() != null && !pref.getCity().isEmpty()) {
            predicates.add(criteriaBuilder.equal(root.get("city"), pref.getCity()));
            LOG.info("sorted by parameter: city");
        }

        if (pref.getDistrict() != null && !pref.getDistrict().isEmpty()) {
            predicates.add(criteriaBuilder.equal(root.get("district"), pref.getDistrict()));
            LOG.info("sorted by parameter: district");
        }

        if (pref.getMinPrice() != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("price"), pref.getMinPrice()));
            LOG.info("sorted by parameter: minPrice");
        }

        if (pref.getMaxPrice() != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("price"), pref.getMaxPrice()));
            LOG.info("sorted by parameter: maxPrice");
        }

        if (pref.getMinArea() != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("area"), pref.getMinArea()));
            LOG.info("sorted by parameter: minArea");
        }

        if (pref.getMaxArea() != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("area"), pref.getMaxArea()));
            LOG.info("sorted by parameter: maxArea");
        }

        if (pref.getMinFloor() != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("floor"), pref.getMinFloor()));
            LOG.info("sorted by parameter: minFloor");
        }

        if (pref.getMaxFloor() != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("floor"), pref.getMaxFloor()));
            LOG.info("sorted by parameter: maxFloor");
        }

        if (pref.getMinRooms() != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("rooms"), pref.getMinRooms()));
            LOG.info("sorted by parameter: minRooms");
        }

        if (pref.getMaxRooms() != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("rooms"), pref.getMaxRooms()));
            LOG.info("sorted by parameter: maxRooms");
        }

        if (pref.isAnimalAllowed() != null) {
            predicates.add(criteriaBuilder.equal(root.get("animalAllowed"), pref.isAnimalAllowed()));
            LOG.info("sorted by parameter: isAnimalAllowed");
        }

        if (pref.isSmokingAllowed() != null) {
            predicates.add(criteriaBuilder.equal(root.get("smokingAllowed"), pref.isSmokingAllowed()));
            LOG.info("sorted by parameter: isSmokingAllowed");
        }

        if (pref.isHasElevator() != null) {
            predicates.add(criteriaBuilder.equal(root.get("hasElevator"), pref.isHasElevator()));
            LOG.info("sorted by parameter: hasElevator");
        }

        if (pref.isOnlyLongTerm() != null) {
            predicates.add(criteriaBuilder.equal(root.get("onlyLongTerm"), pref.isOnlyLongTerm()));
            LOG.info("sorted by parameter: isOnlyLongTerm");
        }

        criteriaQuery.where(predicates.toArray(new Predicate[]{}));
        Query query = entityManager.createQuery(criteriaQuery);
        return (List<Place>) query.getResultList();
    }

    public Long getLastId() {
        Query queryLastId = entityManager.createQuery("SELECT COUNT(*) FROM Place p");
        return (Long) queryLastId.getSingleResult();
    }
}
