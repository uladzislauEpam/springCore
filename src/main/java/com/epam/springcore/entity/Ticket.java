package com.epam.springcore.entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Ticket {

  private int id;

  private int userId;

  private int eventId;

  private String title;

  private int price;

}
