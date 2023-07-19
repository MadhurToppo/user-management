package com.madhurtoppo.usermanagement.resources;

import com.madhurtoppo.usermanagement.dtos.UserDto;
import com.madhurtoppo.usermanagement.dtos.UserIdDto;
import com.madhurtoppo.usermanagement.dtos.UsersDto;
import com.madhurtoppo.usermanagement.entities.ApiResponse;
import com.madhurtoppo.usermanagement.services.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
  public ResponseEntity<ApiResponse> createUser(@RequestBody final UserDto userDto) {
    final HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
    final UserIdDto userIdDto = userService.createUser(userDto);
    final ApiResponse response = new ApiResponse(true, "User successfully added", userIdDto);
    return new ResponseEntity<ApiResponse>(response, httpHeaders, HttpStatus.CREATED);
  }

  /**
   * @return List of {@link UsersDto}
   */
  @GetMapping
  public ResponseEntity<ApiResponse> getAllUsers() {
    final UsersDto usersDto = userService.getAllUsers();
    final HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
    final ApiResponse response = new ApiResponse(true, "All users found", usersDto);
    return new ResponseEntity<ApiResponse>(response, httpHeaders, HttpStatus.OK);
  }

  /**
   * @param id
   * @return {@link UserDto}
   */
  @GetMapping("/{id}")
  public ResponseEntity<ApiResponse> getUser(@PathVariable final Long id) {
    final UserDto userDto = userService.getUser(id);
    final HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
    final ApiResponse response = new ApiResponse(true, "User found", userDto);
    return new ResponseEntity<ApiResponse>(response, httpHeaders, HttpStatus.OK);
  }

  /**
   * @param userDto
   * @param id
   * @return
   */
  @PutMapping("/{id}")
  public ResponseEntity<ApiResponse> update(
      @RequestBody final UserDto userDto, @PathVariable final long id) {

    userService.update(userDto, id);
    final HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
    final ApiResponse response = new ApiResponse(true, "User successfully updated");
    return new ResponseEntity<ApiResponse>(response, httpHeaders, HttpStatus.OK);
  }

  /**
   * @param id
   * @return
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<ApiResponse> delete(@PathVariable final long id) {
    userService.delete(id);
    final HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
    final ApiResponse response = new ApiResponse(true, "User successfully deleted");
    return new ResponseEntity<ApiResponse>(response, httpHeaders, HttpStatus.OK);
  }
}
