package com.epam.springcore.dao.impl;

import com.epam.springcore.entity.Event;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.stereotype.Repository;

public class EventDao implements DestructionAwareBeanPostProcessor {

  private final Map<Integer, Event> map = new HashMap<>();

  public void addToList(int id, String name, String place, Date date) {
    map.put(id, new Event());
  }

  public Map<Integer, Event> getFromList() {
    return map;
  }

  public void deleteFromList(int id) {
    map.remove(id);
  }

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
    return bean;
  }

  @Override
  public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {}
}
