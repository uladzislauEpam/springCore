package com.epam.springcore.service.impl;

import com.epam.springcore.dao.EntityDao;
import com.epam.springcore.entity.User;
import com.epam.springcore.service.EntityService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserService implements EntityService<User> {

  private static final Logger logger = LoggerFactory.getLogger(UserService.class);

  private final EntityDao<User> userDao;

  public UserService(EntityDao<User> dao) {
    this.userDao = dao;
  }

  public User create(User user) {
    return userDao.addToList(user);
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
