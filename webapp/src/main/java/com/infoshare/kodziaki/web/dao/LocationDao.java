package com.infoshare.kodziaki.web.dao;

import com.infoshare.kodziaki.web.model.Location;

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
import java.util.logging.Logger;

@Stateless
public class LocationDao {

    @PersistenceContext
    private EntityManager entityManager;
    Logger logger = Logger.getLogger(getClass().getName());


    public void save(Location location) {
        entityManager.persist(location);
    }

    public List<Location> findAll() {
        final Query query = entityManager.createQuery("SELECT l FROM Location l");
        return (List<Location>) query.getResultList();


    }

    public Location findByName(String district, String city) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Location> criteriaQuery = criteriaBuilder.createQuery(Location.class);
        Root<Location> root = criteriaQuery.from(Location.class);
        List<Predicate> predicates = new ArrayList<>();

        predicates.add(criteriaBuilder.equal(root.get("district"), district));
        predicates.add(criteriaBuilder.equal(root.get("city"), city));

        criteriaQuery.where(predicates.toArray(new Predicate[]{}));
        Query query = entityManager.createQuery(criteriaQuery);
        return (Location) query.getSingleResult();


    }

    public Location findById(long id) {
        return entityManager.find(Location.class, id);

    }
}

