package com.madhurtoppo.usermanagement.services;

import com.madhurtoppo.usermanagement.dtos.UserDto;
import com.madhurtoppo.usermanagement.dtos.UserIdDto;
import com.madhurtoppo.usermanagement.dtos.UsersDto;

/** UserService */
public interface UserService {
  UserIdDto createUser(UserDto userDto);

  UserDto getUser(String id);

  UsersDto getAllUsers();

  void update(UserDto userDto, String id);

  void delete(String id);
}
