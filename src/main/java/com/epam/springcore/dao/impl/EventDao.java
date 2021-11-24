package com.epam.springcore.dao.impl;

import com.epam.springcore.dao.EntityDao;
import com.epam.springcore.entity.Event;
import java.util.HashMap;
import java.util.Map;

public class EventDao implements EntityDao<Event> {

  private final Map<Integer, Event> map = new HashMap<>();

  public Event addToList(Event event) {
    map.put(event.getId(), event);
    return event;
  }

  public Map<Integer, Event> getFromList() {
    return map;
  }

  public void deleteFromList(int id) {
    map.remove(id);
  }
}
