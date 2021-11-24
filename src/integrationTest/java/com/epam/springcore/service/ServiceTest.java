package com.epam.springcore.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.epam.springcore.entity.enums.ActionType;
import com.epam.springcore.entity.enums.EntityType;
import com.epam.springcore.service.impl.EventService;
import com.epam.springcore.service.impl.TicketService;
import com.epam.springcore.service.impl.UserService;
import java.util.HashMap;
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

    userService.create(new HashMap<>() {{
      put("id", "1");
      put("firstName", "Ben");
      put("lastName", "Brown");
      put("age", "30");
    }});

    eventService.create(new HashMap<>() {{
      put("id", "1");
      put("name", "PARTY");
      put("place", "Joe mama");
      put("date", "2022-01-01");
    }});

    ticketService.create(new HashMap<>() {{
      put("id", "1");
      put("userId", "1");
      put("eventId", "1");
      put("title", "NY!!!");
      put("price", "400");
    }});

    assertEquals(1, userService.show().size());
    assertEquals(1, eventService.show().size());
    assertEquals(1, ticketService.show().size());

    ticketService.delete(new HashMap<>() {{
      put("id", "1");
    }});

    assertNotNull(bookingFacade);

//    bookingFacade.delegate(EntityType.TICKET, ActionType.DELETE, new HashMap<>() {{
//      put("id", "1");
//    }});

    assertEquals(1, userService.show().size());
    assertEquals(1, eventService.show().size());
    assertEquals(0, ticketService.show().size());
  }
}
