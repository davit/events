package com.events.beans;

import com.events.model.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;


@Stateless
public class UsersDao implements UsersDaoLocal {
    
    @PersistenceContext(unitName = "EventsPU")
    private EntityManager em;
    
    @Override
    public void create(User user) {
        em.persist(user);
    }
    
    @Override
    public void update(User user) {
        em.merge(user);
    }
    
    @Override
    public void delete(int id) {
        User user = em.find(User.class, id);
        em.remove(user);
    }
    
    @Override
    public User get(int id) {
        return em.find(User.class, id);
    }
    
    @Override
    public List<User> getAll() {
        return em.createNamedQuery("User.findAll").getResultList();
    }
    
    @Override
    public User getByUserAndPassword(String userName, String password) {
        try { User user = (User) em.createNamedQuery("User.findByUserAndPassword")
                .setParameter("userName", userName)
                .setParameter("password", password)
                .getSingleResult();
        return user;
        } catch(NoResultException e) {
            return null;
        }
    }
}
