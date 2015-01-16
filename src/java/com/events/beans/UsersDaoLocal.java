package com.events.beans;

import com.events.model.User;
import java.util.List;
import javax.ejb.Local;


@Local
public interface UsersDaoLocal {
    void create(User user);
    void update(User user);
    void delete(int id);    
    User get(int id);
    List<User> getAll();
    User getByUserAndPassword(String userName, String password);    
}
