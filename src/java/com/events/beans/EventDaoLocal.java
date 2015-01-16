package com.events.beans;

import com.events.model.Event;
import java.util.List;
import javax.ejb.Local;


@Local
public interface EventDaoLocal {
    void create(Event event);
    void update(Event event);
    void delete(int id);
    Event get(int id);
    List<Event> getAll();
}
