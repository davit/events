package com.events.beans;

import com.events.model.Event;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class EventDao implements EventDaoLocal {
    @PersistenceContext(unitName = "EventsPU")
    private EntityManager em;
    
    @Override
    public void create(Event event) {
        em.persist(event);
    }
    
    @Override
    public void update(Event event) {
        em.merge(event);
    }
    
    @Override
    public void delete(int id) {
        Event event = em.find(Event.class, id);
        em.remove(event);
    }
    
    @Override
    public Event get(int id) {
        return em.find(Event.class, id);
    }
    
    @Override
    public List<Event> getAll() {
        return em.createNamedQuery("Event.findAll").getResultList();
    }
    
}
