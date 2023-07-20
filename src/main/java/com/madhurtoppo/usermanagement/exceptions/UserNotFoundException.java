package com.madhurtoppo.usermanagement.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/** UserNotFoundException */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

  public UserNotFoundException(String id) {
    super("User with id '%s' not found!".formatted(id));
  }
}
