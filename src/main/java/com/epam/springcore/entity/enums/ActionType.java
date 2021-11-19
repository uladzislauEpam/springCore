package com.epam.springcore.entity.enums;

public enum ActionType {
  CREATE, DELETE, SHOW;

  @Override
  public String toString() {
    return super.toString().toLowerCase();
  }
}
