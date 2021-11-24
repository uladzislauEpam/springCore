package com.epam.springcore;

import com.epam.springcore.service.impl.UserService;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringCoreApplication {
  public static void main(String[] args) {
    {
      Logger logger = Logger.getLogger(SpringCoreApplication.class.getName());
      ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
      UserService userService = (UserService) ac.getBean("userService");
      userService.create(1, "Ben", "Brown", 30);
      userService.show();
      logger.log(Level.WARNING, "1 object created");
      ac.close();
    }
  }
}

