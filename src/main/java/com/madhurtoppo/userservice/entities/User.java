package com.madhurtoppo.userservice.entities;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

/** User */
@Data
@NoArgsConstructor
@Entity
public class User {

  private Long id;
  private String name;
  private String email;
  private String password;
}
