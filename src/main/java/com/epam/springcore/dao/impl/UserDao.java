package com.epam.springcore.dao.impl;

import com.epam.springcore.entity.User;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

public class UserDao {

  private final Map<Integer, User> map = new HashMap<>();

  public User addToList(int id, String firstName, String lastName, int age) {
    User user = new User(id, firstName, lastName, age);
    map.put(id, user);
    return user;
  }

  public Map<Integer, User> getFromList() {
    return map;
  }

  public void deleteFromList(int id) {
    map.remove(id);
  }
}
