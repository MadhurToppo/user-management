package com.madhurtoppo.usermanagement.services;

import com.madhurtoppo.usermanagement.dtos.UserDto;
import com.madhurtoppo.usermanagement.dtos.UserIdDto;
import com.madhurtoppo.usermanagement.dtos.UsersDto;

/** UserService */
public interface UserService {
  public UserIdDto createUser(UserDto userDto);

  public UserDto getUser(String id);

  public UsersDto getAllUsers();

  public void update(UserDto userDto, String id);

  public void delete(String id);
}
