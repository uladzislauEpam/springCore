package com.epam.springcore.service.impl;

import com.epam.springcore.dao.EntityDao;
import com.epam.springcore.entity.Event;
import com.epam.springcore.service.EntityService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EventService implements EntityService<Event> {

  private EntityDao<Event> eventDao;

  public EventService(EntityDao<Event> dao) {
    this.eventDao = dao;
  }

  public Event create(Event event) {
    return eventDao.addToList(event);
  }

  public Map<Integer, Event> show() {
    return eventDao.getFromList();
  }

  public List<Event> showAsList() {
    Map<Integer, Event> map = eventDao.getFromList();
    return new ArrayList<>(map.values());
  }

  public void delete(int id) {
    eventDao.deleteFromList(id);
  }
}