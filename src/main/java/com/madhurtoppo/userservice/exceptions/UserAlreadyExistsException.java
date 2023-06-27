package com.madhurtoppo.userservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/** UserAlreadyExistsException */
@ResponseStatus(HttpStatus.OK)
public class UserAlreadyExistsException extends RuntimeException {

  /**
   * @param name
   */
  public UserAlreadyExistsException(String name) {
    super("User '%s' already exists!".formatted(name));
  }
}
