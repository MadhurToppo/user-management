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
    final String name = user.getName();
    final int age = user.getAge();
    final String city = user.getCity();
    return new UserDto(name, age, city);
  }

  /**
   * @param userDto
   * @return {@link User}
   */
  public User toEntity(final UserDto userDto) {
    final String name = userDto.getName();
    final int age = userDto.getAge();
    final String city = userDto.getCity();
    return new User(name, age, city);
  }
}
