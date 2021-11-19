package com.epam.springcore.service;

import com.epam.springcore.entity.enums.EntityType;
import java.util.Map;

public interface EntityService<T> {

    EntityType supportedEntityType();

    void create(Map<String, String> parameters);

    T show();

    void delete(Map<String, String> parameters);

}
