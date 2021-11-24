package com.epam.springcore.entity;

import java.util.Date;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

//@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode
//@ToString
public class Ticket {

  private int id;

  private int userId;

  private int eventId;

  private String title;

  private int price;

  public Ticket(int id, int userId, int eventId, String title, int price) {
    this.id = id;
    this.userId = userId;
    this.eventId = eventId;
    this.title = title;
    this.price = price;
  }

  public int getId() {
    return id;
  }

  @Override
  public String toString() {
    return "Ticket{"
        + "id='" + id + '\''
        + ", userId=" + userId
        + ", eventId=" + eventId
        + ", title=" + title
        + ", price=" + price
        + '}';
  }

}
