package com.epam.springcore.service.delegator;

import com.epam.springcore.entity.Event;
import com.epam.springcore.entity.Ticket;
import com.epam.springcore.entity.User;
import com.epam.springcore.service.BookingFacade;
import com.epam.springcore.service.impl.EventService;
import com.epam.springcore.service.impl.TicketService;
import com.epam.springcore.service.impl.UserService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingFacadeImpl implements BookingFacade {

  @Autowired
  UserService userService;

  @Autowired
  TicketService ticketService;

  @Autowired
  EventService eventService;

  @Override
  public User createUser(int id, String firstName, String lastName, int age) {
    return userService.create(id, firstName, lastName, age);
  }

  @Override
  public void deleteUser(int id) {
    userService.delete(id);
  }

  @Override
  public List<User> getUsers() {
    return userService.showAsList();
  }

  @Override
  public Event createEvent(int id, String name, String place, Date date) {
    return eventService.create(id, name, place, date);
  }

  @Override
  public void deleteEvent(int id) {
    eventService.delete(id);
  }

  @Override
  public List<Event> getEvents() {
    return eventService.showAsList();
  }

  @Override
  public Ticket bookTicket(int id, User user, Event event, String title, int price) {
    return ticketService.create(id, user.getId(), event.getId(), title, price);
  }

  @Override
  public void returnTicket(int id) {
    ticketService.delete(id);
  }

  @Override
  public List<Ticket> getBookedTickets() {
    return ticketService.showAsList();
  }
}