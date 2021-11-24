package com.epam.springcore.dao;

import java.util.Map;

public interface EntityDao<T> {

  T addToList(T entity);

  Map<Integer, T> getFromList();

  void deleteFromList(int id);

}
