package com.epam.springcore.service.impl;

import com.epam.springcore.dao.impl.EventDao;
import com.epam.springcore.entity.Event;
import com.epam.springcore.entity.enums.EntityType;
import com.epam.springcore.service.EntityService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class EventService implements EntityService<Map<Integer, Event>> {

  @Autowired
  EventDao eventDao;

  @Override
  public EntityType supportedEntityType() {
    return EntityType.EVENT;
  }

  @Override
  public void create(Map<String, String> parameters) {
    try {
      int id = Integer.parseInt(parameters.get("id"));
      String name = parameters.get("name");
      String place = parameters.get("place");
      Date date = new SimpleDateFormat("dd/MM/yyyy").parse(parameters.get("date"));
      eventDao.addToList(id, name, place, date);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public Map<Integer, Event> show() {
    return eventDao.getFromList();
  }

  @Override
  public void delete(Map<String, String> parameters) {
    try {
      int id = Integer.parseInt(parameters.get("id"));
      eventDao.deleteFromList(id);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}