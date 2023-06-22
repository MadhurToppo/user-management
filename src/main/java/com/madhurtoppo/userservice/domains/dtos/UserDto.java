package com.madhurtoppo.userservice.domains.dtos;

import lombok.Data;

/** UserDto */
@Data
public class UserDto {

  private Long id;
  private String name;
  private String email;
  private String password;
}
