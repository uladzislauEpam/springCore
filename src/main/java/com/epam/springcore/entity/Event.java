package com.epam.springcore.entity;

import java.util.Date;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@EqualsAndHashCode
//@ToString
public class Event {

  private int id;

  private String name;

  private String place;

  private Date date;

  public Event(int id, String name, String place, Date date) {
    this.id = id;
    this.name = name;
    this.place = place;
    this.date = date;
  }

  @Override
  public String toString() {
    return "Event{"
        + "id='" + id + '\''
        + ", name=" + name
        + ", place=" + place
        + ", date=" + date
        + '}';
  }

}
