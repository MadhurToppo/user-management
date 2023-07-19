package com.madhurtoppo.usermanagement.services;

import com.madhurtoppo.usermanagement.dtos.UserDto;
import com.madhurtoppo.usermanagement.dtos.UsersDto;
import com.madhurtoppo.usermanagement.entities.ApiResponse;

/** UserService */
public interface UserService {
  public ApiResponse createUser(UserDto userDto);

  public ApiResponse getUser(long id);

  public UsersDto getAllUsers();

  public String update(UserDto userDto, long id);

  public String delete(long id);
}
