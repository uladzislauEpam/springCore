package com.epam.springcore.service.impl;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

import com.epam.springcore.dao.impl.UserDao;
import com.epam.springcore.entity.User;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class UserServiceTest {

  @Mock
  UserService userService;
  @Mock
  UserDao userDao;

  @BeforeEach
  void setUp() {
    userDao = Mockito.spy(new UserDao());
    userService = Mockito.spy(new UserService());
    userService.userDao = userDao;
  }

  @Test
  void userService_show_Success() {
    Map<Integer, User> map = new HashMap<>() {{
      put(1, new User(1, "Kyle", "Braddock", 30));
    }};
    doReturn(map).when(userDao).getFromList();
    assertDoesNotThrow(() -> userService.show());
    assertEquals(1, userService.show().size());
  }

}
