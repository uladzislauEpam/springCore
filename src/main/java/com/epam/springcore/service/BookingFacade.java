package com.epam.springcore.service;

import com.epam.springcore.entity.enums.ActionType;
import com.epam.springcore.entity.enums.EntityType;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public interface BookingFacade {

  void init();

  void delegate(EntityType mode, ActionType action, Map<String, String>... parameters);

}
