package com.epam.springcore.dao.impl;

import com.epam.springcore.entity.User;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

public class UserDao {

  private final Map<Integer, User> map = new HashMap<>();

  public void addToList(int id, String firstName, String lastName, int age) {
    User user = new User(id, firstName, lastName, age);
    map.put(id, user);
  }

  public Map<Integer, User> getFromList() {
    return map;
  }

  public void deleteFromList(int id) {
    map.remove(id);
  }

  public String convertWithStream() {
    User user = map.get(1);
    String value = user.toString();
    return map.keySet().stream()
        .map(key -> key + "=" + map.get(key).toString())
        .collect(Collectors.joining(", ", "{", "}"));
  }
}
