package com.epam.springcore.service.impl;

import com.epam.springcore.dao.impl.EventDao;
import com.epam.springcore.dao.impl.TicketDao;
import com.epam.springcore.entity.Event;
import com.epam.springcore.entity.Ticket;
import com.epam.springcore.entity.enums.EntityType;
import com.epam.springcore.service.EntityService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class TicketService implements EntityService<Map<Integer, Ticket>> {

  @Autowired
  TicketDao ticketDao;

  @Override
  public EntityType supportedEntityType() {
    return EntityType.TICKET;
  }

  @Override
  public void create(Map<String, String> parameters) {
    try {
      int id = Integer.parseInt(parameters.get("id"));
      int userId = Integer.parseInt(parameters.get("userId"));
      int eventId = Integer.parseInt(parameters.get("eventId"));
      String title = parameters.get("title");
      int price = Integer.parseInt(parameters.get("price"));
      ticketDao.addToList(id, userId, eventId, title, price);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public Map<Integer, Ticket> show() {
    return ticketDao.getFromList();
  }

  @Override
  public void delete(Map<String, String> parameters) {
    try {
      int id = Integer.parseInt(parameters.get("id"));
      ticketDao.deleteFromList(id);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}