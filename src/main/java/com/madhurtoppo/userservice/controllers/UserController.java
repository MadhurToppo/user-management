package com.madhurtoppo.userservice.controllers;

import com.madhurtoppo.userservice.domains.User;
import com.madhurtoppo.userservice.domains.dtos.UserDto;
import com.madhurtoppo.userservice.domains.dtos.UsersDto;
import com.madhurtoppo.userservice.services.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/** UserController */
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

  private final UserServiceImpl userService;

  /**
   * @param userDto
   * @return id of {@link User}
   */
  @PostMapping
  @ResponseStatus(HttpStatus.OK)
  public Long createUser(@RequestBody final UserDto userDto) {
    final long id = userService.createUser(userDto);
    return id;
  }

  /**
   * @param id
   * @return {@link UserDto}
   */
  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.CREATED)
  public UserDto getUser(@PathVariable final Long id) {
    final UserDto userDto = userService.getUser(id);
    return userDto;
  }

  /**
   * @return List of {@link UsersDto}
   */
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public UsersDto getAllUsers() {
    final UsersDto users = userService.getAllUsers();
    return users;
  }
}
