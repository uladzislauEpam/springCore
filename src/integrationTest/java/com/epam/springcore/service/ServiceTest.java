package com.epam.springcore.service;

import com.epam.springcore.entity.Event;
import com.epam.springcore.entity.User;
import java.util.Date;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:ApplicationContext.xml")
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@EnableConfigurationProperties
public class ServiceTest {

  @Mock
  private BookingFacade bookingFacade;

  @Test
  public void testMessageChannelSendAndReceive() {

    User user = bookingFacade.createUser(1, "Ben", "Ten", 20);
    Event event = bookingFacade.createEvent(1, "PARTY", "Joe mama", new Date());
    bookingFacade.bookTicket(1, user, event, "NY", 400);

    Assertions.assertNotNull(bookingFacade);

    bookingFacade.returnTicket(1);

    Assertions.assertEquals(1, bookingFacade.getUsers().size());
    Assertions.assertEquals(1, bookingFacade.getEvents().size());
    Assertions.assertEquals(0, bookingFacade.getBookedTickets().size());
  }
}
