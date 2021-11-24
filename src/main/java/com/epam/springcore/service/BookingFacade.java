package com.epam.springcore.service;

import com.epam.springcore.entity.Event;
import com.epam.springcore.entity.Ticket;
import com.epam.springcore.entity.User;
import com.epam.springcore.entity.enums.ActionType;
import com.epam.springcore.entity.enums.EntityType;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface BookingFacade {

  User createUser(int id, String firstName, String lastName, int age);

  void deleteUser(int id);

  List<User> getUsers();

  Event createEvent(int id, String name, String place, Date date);

  void deleteEvent(int id);

  List<Event> getEvents();

  Ticket bookTicket(int id, User user, Event event, String title, int price);

  void returnTicket(int id);

  List<Ticket> getBookedTickets();

}
