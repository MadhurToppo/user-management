package com.madhurtoppo.usermanagement.services;

import com.madhurtoppo.usermanagement.dtos.UserDto;
import com.madhurtoppo.usermanagement.entities.ApiResponse;

/** UserService */
public interface UserService {
  public ApiResponse createUser(UserDto userDto);

  public ApiResponse getUser(long id);

  public ApiResponse getAllUsers();

  public ApiResponse update(UserDto userDto, long id);

  public ApiResponse delete(long id);
}
