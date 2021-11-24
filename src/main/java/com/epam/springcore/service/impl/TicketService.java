package com.epam.springcore.service.impl;

import com.epam.springcore.dao.EntityDao;
import com.epam.springcore.entity.Ticket;
import com.epam.springcore.service.EntityService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TicketService implements EntityService<Ticket> {

  private EntityDao<Ticket> ticketDao;

  public TicketService(EntityDao<Ticket> dao) {
    this.ticketDao = dao;
  }

  public Ticket create(Ticket ticket) {
    return ticketDao.addToList(ticket);
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