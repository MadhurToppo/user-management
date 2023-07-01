package com.madhurtoppo.usermanagement.resources;

import com.madhurtoppo.usermanagement.dtos.UserDto;
import com.madhurtoppo.usermanagement.dtos.UsersDto;
import com.madhurtoppo.usermanagement.services.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    return new ResponseEntity<Long>(id, HttpStatus.CREATED);
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
    return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
  }

  /**
   * @param userDto
   * @param id
   * @return
   */
  @PutMapping("/{id}")
  public ResponseEntity<String> update(
      @RequestBody final UserDto userDto, @PathVariable final long id) {

    final String message = userService.update(userDto, id);
    return new ResponseEntity<String>(message, HttpStatus.OK);
  }

  /**
   * @param id
   * @return
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<String> delete(@PathVariable final long id) {
    final String message = userService.delete(id);
    return new ResponseEntity<String>(message, HttpStatus.OK);
  }
}
