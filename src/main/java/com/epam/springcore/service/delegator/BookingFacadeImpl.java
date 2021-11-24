package com.epam.springcore.service.delegator;

import com.epam.springcore.entity.Event;
import com.epam.springcore.entity.Ticket;
import com.epam.springcore.entity.User;
import com.epam.springcore.service.BookingFacade;
import com.epam.springcore.service.EntityService;
import java.util.Date;
import java.util.List;

public class BookingFacadeImpl implements BookingFacade {

  private final EntityService<User> userService;

  private final EntityService<Ticket> ticketService;

  private final EntityService<Event> eventService;

  public BookingFacadeImpl(EntityService<User> userService,
      EntityService<Ticket> ticketService,
      EntityService<Event> eventService) {
    this.ticketService = ticketService;
    this.eventService = eventService;
    this.userService = userService;
  }

  @Override
  public User createUser(int id, String firstName, String lastName, int age) {
    User user = new User(id, firstName, lastName, age);
    return userService.create(user);
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
    Event event = new Event(id, name, place, date);
    return eventService.create(event);
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
    Ticket ticket = new Ticket(id, user.getId(), event.getId(), title, price);
    return ticketService.create(ticket);
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