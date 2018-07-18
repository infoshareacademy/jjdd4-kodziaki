package com.infoshare.kodziaki.web.dao;

import com.infoshare.kodziaki.model.District;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class DistrictDao {

    private Logger LOG = LoggerFactory.getLogger(DistrictDao.class);

    @PersistenceContext
    private EntityManager entityManager;

    public void save(District district) {
        entityManager.persist(district);
    }

    public List<District> getAll() {
        final Query query = entityManager.createQuery("SELECT d FROM District d");
        return (List<District>) query.getResultList();
    }
}

