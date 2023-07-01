package com.madhurtoppo.usermanagement.dtos;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/** UsersDto */
@Getter
@Setter
@AllArgsConstructor
public class UsersDto {
  private List<UserDto> users;
}
