package com.epam.springcore.service.impl;

import com.epam.springcore.dao.impl.EventDao;
import com.epam.springcore.entity.Event;
import com.epam.springcore.entity.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

public class EventService {

  @Autowired
  EventDao eventDao;

  public Event create(int id, String name, String place, Date date) {
    return eventDao.addToList(id, name, place, date);
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