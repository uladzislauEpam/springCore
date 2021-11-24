package com.epam.springcore.service.impl;

import com.epam.springcore.dao.impl.UserDao;
import com.epam.springcore.entity.User;
import com.epam.springcore.entity.enums.EntityType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

  private static final Logger logger = LoggerFactory.getLogger(UserService.class);

  @Autowired
  UserDao userDao;

  public User create(int id, String firstName, String lastName, int age) {
    return userDao.addToList(id, firstName, lastName, age);
  }
  
  public Map<Integer, User> show() {
    Map<Integer, User> map = userDao.getFromList();
    logger.info(map.toString());
    return map;
  }
  
  public List<User> showAsList() {
    Map<Integer, User> map = userDao.getFromList();
    return new ArrayList<>(map.values());
  }
  
  public void delete(int id) {
    userDao.deleteFromList(id);
  }

}
