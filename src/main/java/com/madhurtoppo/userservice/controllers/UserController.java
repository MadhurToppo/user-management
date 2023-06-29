package com.madhurtoppo.userservice.controllers;

import com.madhurtoppo.userservice.domains.User;
import com.madhurtoppo.userservice.domains.dtos.UserDto;
import com.madhurtoppo.userservice.domains.dtos.UsersDto;
import com.madhurtoppo.userservice.services.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
  public ResponseEntity<Long> createUser(@RequestBody final UserDto userDto) {
    final long id = userService.createUser(userDto);
    return new ResponseEntity<Long>(id, HttpStatus.OK);
  }

  /**
   * @return List of {@link UsersDto}
   */
  @GetMapping
  public ResponseEntity<UsersDto> getAllUsers() {
    final UsersDto users = userService.getAllUsers();
    return new ResponseEntity<UsersDto>(users, HttpStatus.OK);
  }

  /**
   * @param id
   * @return {@link UserDto}
   */
  @GetMapping("/{id}")
  public ResponseEntity<UserDto> getUser(@PathVariable final Long id) {
    final UserDto userDto = userService.getUser(id);
    return new ResponseEntity<UserDto>(userDto, HttpStatus.CREATED);
  }
}
