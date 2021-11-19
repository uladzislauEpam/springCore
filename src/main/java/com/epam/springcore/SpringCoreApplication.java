package com.epam.springcore;

import com.epam.springcore.entity.enums.ActionType;
import com.epam.springcore.entity.enums.EntityType;
import com.epam.springcore.service.BookingFacade;
import com.epam.springcore.service.delegator.BookingFacadeImpl;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCoreApplication {

  @Autowired
  static BookingFacadeImpl bookingFacade;

  public static void main(String[] args) {
    SpringApplication.run(SpringCoreApplication.class, args);
  }
}

