package com.infoshare.kodziaki.web.dao;

import com.infoshare.kodziaki.model.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class CityDao {

    private Logger LOG = LoggerFactory.getLogger(CityDao.class);

    @PersistenceContext
    private EntityManager entityManager;

    public void save(City city) {
        entityManager.persist(city);
    }

    public List<City> getAll() {
        final Query query = entityManager.createQuery("SELECT c FROM City c");
        return (List<City>) query.getResultList();
    }
}
