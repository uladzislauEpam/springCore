package com.epam.springcore.service.delegator;

import com.epam.springcore.entity.enums.ActionType;
import com.epam.springcore.entity.enums.EntityType;
import com.epam.springcore.service.BookingFacade;
import com.epam.springcore.service.EntityService;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingFacadeImpl implements BookingFacade {

  @Autowired
  private final List<EntityService> entityServices;

  private Map<EntityType, EntityService> entityServiceMap;

  public BookingFacadeImpl(List<EntityService> entityServices) {
    this.entityServices = entityServices;
  }

  @PostConstruct
  public void init() {
    entityServiceMap = new HashMap<>();
    for (EntityService entityService : entityServices) {
      entityServiceMap.put(entityService.supportedEntityType(), entityService);
    }
  }

  @SafeVarargs
  public final void delegate(EntityType entity, ActionType action,
      Map<String, String>... parameters) {
    Map<String, String> parameter;
    try {
    if(Arrays.stream(parameters).count() != 1) {
      throw new Exception("wrong init");
    } else {
      parameter = Arrays.stream(parameters)
          .reduce((first, second) -> first)
          .orElse(new HashMap<>());
    }
      Method method = entityServiceMap.get(entity).getClass().getMethod(action.toString());
      method.invoke(entityServiceMap.get(entity), parameter);
    } catch (Exception ignored) {}
  }

}
