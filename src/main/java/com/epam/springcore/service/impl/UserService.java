package com.epam.springcore.service.impl;

import com.epam.springcore.dao.impl.UserDao;
import com.epam.springcore.entity.User;
import com.epam.springcore.entity.enums.EntityType;
import com.epam.springcore.service.EntityService;
import java.util.Map;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService implements EntityService<Map<Integer, User>> {

  private static final Logger logger = LoggerFactory.getLogger(UserService.class);

  @Autowired
  UserDao userDao;

  @Override
  public EntityType supportedEntityType() {
    return EntityType.USER;
  }

  @Override
  public void create(Map<String, String> parameters) {
    try {
      int id = Integer.parseInt(parameters.get("id"));
      String firstName = parameters.get("firstName");
      String lastName = parameters.get("lastName");
      int age = Integer.parseInt(parameters.get("age"));
      userDao.addToList(id, firstName, lastName, age);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public Map<Integer, User> show() {
    Map<Integer, User> map = userDao.getFromList();
    logger.info(map.toString());
    return map;
  }

  @Override
  public void delete(Map<String, String> parameters) {
    try {
      int id = Integer.parseInt(parameters.get("id"));
      userDao.deleteFromList(id);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
