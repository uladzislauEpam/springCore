package com.epam.springcore.dao.impl;

import com.epam.springcore.dao.EntityDao;
import com.epam.springcore.entity.User;
import java.util.HashMap;
import java.util.Map;

public class UserDao implements EntityDao<User> {

  private final Map<Integer, User> map = new HashMap<>();

  public User addToList(User user) {
    map.put(user.getId(), user);
    return user;
  }

  public Map<Integer, User> getFromList() {
    return map;
  }

  public void deleteFromList(int id) {
    map.remove(id);
  }
}
