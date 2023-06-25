package com.madhurtoppo.userservice.domains.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

/** UserDto */
@Data
@AllArgsConstructor
public class UserDto {
  private String name;
  private int age;
  private String city;
}
