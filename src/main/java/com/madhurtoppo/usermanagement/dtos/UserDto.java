package com.madhurtoppo.usermanagement.dtos;

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
