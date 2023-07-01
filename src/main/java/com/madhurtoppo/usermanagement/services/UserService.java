package com.madhurtoppo.usermanagement.services;

import com.madhurtoppo.usermanagement.dtos.UserDto;
import com.madhurtoppo.usermanagement.dtos.UsersDto;

/** UserService */
public interface UserService {
  public Long createUser(UserDto userDto);

  public UserDto getUser(long id);

  public UsersDto getAllUsers();

  public String update(UserDto userDto, long id);

  public String delete(long id);
}
