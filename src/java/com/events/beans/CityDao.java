package com.events.beans;

import com.events.model.City;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Stateless
public class CityDao implements CityDaoLocal {
    @PersistenceContext(unitName = "EventsPU")
    private EntityManager em;
    
    @Override
    public void create(City city) {
        em.persist(city);
    }
    
    @Override
    public void update(City city) {
        em.merge(city);
    }
    
    @Override
    public void delete(int id) {
        City city = em.find(City.class, id);
        em.remove(city);
    }
    
    @Override
    public City get(int id) {
        return em.find(City.class, id);
    }
    
    @Override
    public List<City> getAll() {
        return em.createNamedQuery("City.findAll").getResultList();
    }
    
}
