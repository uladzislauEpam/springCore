package com.epam.springcore.entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
//@AllArgsConstructor
@EqualsAndHashCode
//@ToString
public class User {

  private int id;

  private String firstName;

  private String lastName;

  private int age;

  public User(int id, String firstName, String lastName, int age) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  }

  @Override
  public String toString() {
    return "User{"
        + "id='" + id + '\''
        + ", firstName=" + firstName
        + ", lastName=" + lastName
        + ", age=" + age
        + '}';
  }

}
