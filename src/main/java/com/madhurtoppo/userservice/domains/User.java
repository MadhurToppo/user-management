package com.madhurtoppo.userservice.domains;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

/** User */
@Data
@NoArgsConstructor
@Entity
public class User {

  @Id private Long id;
  private String name;
  private String email;
  private String password;
}
