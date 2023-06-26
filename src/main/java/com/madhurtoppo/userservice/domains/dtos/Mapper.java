package com.madhurtoppo.userservice.domains.dtos;

import com.madhurtoppo.userservice.domains.User;
import org.springframework.stereotype.Component;

/** Mapper */
@Component
public class Mapper {

  /**
   * @param user
   * @return {@link UserDto}
   */
  public UserDto toDto(final User user) {
    return new UserDto(user.getName(), user.getAge(), user.getCity());
  }

  /**
   * @param userDto
   * @return {@link User}
   */
  public User toEntity(final UserDto userDto) {
    return new User(userDto.getName(), userDto.getAge(), userDto.getCity());
  }
}
