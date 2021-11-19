package com.epam.springcore.dao.impl;

import com.epam.springcore.entity.User;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

  private final Map<Integer, User> map = new HashMap<>();

  public void addToList(int id, String firstName, String lastName, int age) {
    map.put(id, new User());
  }

  public Map<Integer, User> getFromList() {
    return map;
  }

  public void deleteFromList(int id) {
    map.remove(id);
  }
}
