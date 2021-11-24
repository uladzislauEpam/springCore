package com.epam.springcore.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.epam.springcore.entity.Event;
import com.epam.springcore.entity.User;
import com.epam.springcore.service.impl.EventService;
import com.epam.springcore.service.impl.TicketService;
import com.epam.springcore.service.impl.UserService;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:ApplicationContext.xml")
@DirtiesContext(classMode=ClassMode.AFTER_EACH_TEST_METHOD)
public class ServiceTest {

  @Autowired
  UserService userService;

  @Autowired
  TicketService ticketService;

  @Autowired
  EventService eventService;

  @Autowired
  BookingFacade bookingFacade;

  @Test
  public void testMessageChannelSendAndReceive()
  {
    assertNotNull(userService);
    assertNotNull(ticketService);
    assertNotNull(eventService);

    User user = bookingFacade.createUser(1, "Ben", "Ten", 20);
    Event event = bookingFacade.createEvent(1, "PARTY", "Joe mama", new Date());
    bookingFacade.bookTicket(1, user, event, "NY", 400);

    assertEquals(1, userService.show().size());
    assertEquals(1, eventService.show().size());
    assertEquals(1, ticketService.show().size());

    assertNotNull(bookingFacade);

    bookingFacade.returnTicket(1);

    assertEquals(1, userService.show().size());
    assertEquals(1, eventService.show().size());
    assertEquals(0, ticketService.show().size());
  }
}
