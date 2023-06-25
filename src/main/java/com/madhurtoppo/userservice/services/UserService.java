package com.madhurtoppo.userservice.services;

import com.madhurtoppo.userservice.domains.dtos.UserDto;

/** UserService */
public interface UserService {

  public Long createUser(UserDto userDto);

  public UserDto getUser(long id);
}
