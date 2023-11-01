package com.madhurtoppo.usermanagement.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.OK)
public class UserAlreadyExistsException extends RuntimeException {

  public UserAlreadyExistsException(String name) {
    super("User '%s' already exists!".formatted(name));
  }
}
