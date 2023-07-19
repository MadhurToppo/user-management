package com.madhurtoppo.usermanagement.services;

import com.madhurtoppo.usermanagement.dtos.UserDto;
import com.madhurtoppo.usermanagement.dtos.UserIdDto;
import com.madhurtoppo.usermanagement.dtos.UsersDto;

/** UserService */
public interface UserService {
  public UserIdDto createUser(UserDto userDto);

  public UserDto getUser(long id);

  public UsersDto getAllUsers();

  public void update(UserDto userDto, long id);

  public void delete(long id);
}
