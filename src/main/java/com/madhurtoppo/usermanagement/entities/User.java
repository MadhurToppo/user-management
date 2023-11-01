package com.madhurtoppo.usermanagement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

/** User */
@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

  @Id
  @UuidGenerator
  private String id;
  private String name;
  private int age;
  private String city;

  public User(final String name, final int age, final String city) {
    this.name = name;
    this.age = age;
    this.city = city;
  }
}
