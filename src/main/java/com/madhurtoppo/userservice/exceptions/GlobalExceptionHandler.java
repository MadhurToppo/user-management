package com.madhurtoppo.userservice.exceptions;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/** GlobalExceptionHandler */
@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<Error> userNotFound(UserNotFoundException exception, WebRequest request) {
    Error error = new Error(exception.getMessage(), request.getDescription(false), new Date());
    return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(UserAlreadyExistsException.class)
  public ResponseEntity<Error> userAlreadyExists(UserAlreadyExistsException e, WebRequest r) {
    Error error = new Error(e.getMessage(), r.getDescription(false), new Date());
    return new ResponseEntity<Error>(error, HttpStatus.OK);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<Error> globalExceptions(Exception exception, WebRequest request) {
    Error error = new Error(exception.getMessage(), request.getDescription(false), new Date());
    return new ResponseEntity<Error>(error, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
