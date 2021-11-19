package com.epam.springcore.dao.impl;

import com.epam.springcore.entity.Ticket;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class TicketDao {

  private final Map<Integer, Ticket> map = new HashMap<>();

  public void addToList(int id, int userId, int eventId, String title, int price) {
    map.put(id, new Ticket());
  }

  public Map<Integer, Ticket> getFromList() {
    return map;
  }

  public void deleteFromList(int id) {
    map.remove(id);
  }

}
