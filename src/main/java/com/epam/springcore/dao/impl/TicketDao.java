package com.epam.springcore.dao.impl;

import com.epam.springcore.entity.Ticket;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

public class TicketDao {

  private final Map<Integer, Ticket> map = new HashMap<>();

  public Ticket addToList(int id, int userId, int eventId, String title, int price) {
    Ticket ticket = new Ticket(id, userId, eventId, title, price);
    map.put(id, ticket);
    return ticket;
  }

  public Map<Integer, Ticket> getFromList() {
    return map;
  }

  public void deleteFromList(int id) {
    map.remove(id);
  }

}
