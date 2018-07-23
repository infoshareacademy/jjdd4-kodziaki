package com.infoshare.kodziaki.web.dao;

import com.infoshare.kodziaki.web.model.Location;
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

@Stateless
public class LocationDao {

    private Logger LOG = LoggerFactory.getLogger(PlaceDao.class);

    @PersistenceContext
    private EntityManager entityManager;

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

