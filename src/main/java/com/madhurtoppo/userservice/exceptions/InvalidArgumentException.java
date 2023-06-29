package com.madhurtoppo.userservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/** UserNotFoundException */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidArgumentException extends RuntimeException {

  public InvalidArgumentException() {
    super("Invalid arguments, please enter again.");
  }
}
