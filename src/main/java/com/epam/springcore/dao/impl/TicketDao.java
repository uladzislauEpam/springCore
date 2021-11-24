package com.epam.springcore.dao.impl;

import com.epam.springcore.dao.EntityDao;
import com.epam.springcore.entity.Ticket;
import java.util.HashMap;
import java.util.Map;

public class TicketDao implements EntityDao<Ticket> {

  private final Map<Integer, Ticket> map = new HashMap<>();

  public Ticket addToList(Ticket ticket) {
    map.put(ticket.getId(), ticket);
    return ticket;
  }

  public Map<Integer, Ticket> getFromList() {
    return map;
  }

  public void deleteFromList(int id) {
    map.remove(id);
  }

}
