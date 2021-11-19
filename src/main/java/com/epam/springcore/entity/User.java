package com.epam.springcore.entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class User {

  private int id;

  private String firstName;

  private String lastName;

  private int age;

}
