package com.epam.springcore.service;

import java.util.List;
import java.util.Map;

public interface EntityService<T> {

  T create(T entity);

  Map<Integer, T> show();

  List<T> showAsList();

  void delete(int id);

}
