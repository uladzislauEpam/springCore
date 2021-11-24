package com.epam.springcore.service.impl;

import com.epam.springcore.dao.impl.TicketDao;
import com.epam.springcore.entity.Ticket;
import com.epam.springcore.entity.Ticket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

public class TicketService {

  @Autowired
  TicketDao ticketDao;

  public Ticket create(int id, int userId, int eventId, String title, int price) {
    return ticketDao.addToList(id, userId, eventId, title, price);
  }

  public Map<Integer, Ticket> show() {
    return ticketDao.getFromList();
  }

  public List<Ticket> showAsList() {
    Map<Integer, Ticket> map = ticketDao.getFromList();
    return new ArrayList<>(map.values());
  }

  public void delete(int id) {
    ticketDao.deleteFromList(id);
  }
}