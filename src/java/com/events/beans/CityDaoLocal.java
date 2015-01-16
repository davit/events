package com.events.beans;

import com.events.model.City;
import java.util.List;
import javax.ejb.Local;

@Local
public interface CityDaoLocal {    
    void create(City city);
    void update(City city);
    void delete(int id);
    City get(int id);
    List<City> getAll();
    
}
