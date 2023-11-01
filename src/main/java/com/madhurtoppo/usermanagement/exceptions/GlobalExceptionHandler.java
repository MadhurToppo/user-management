package com.madhurtoppo.usermanagement.exceptions;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/** GlobalExceptionHandler */
@ControllerAdvice
public class GlobalExceptionHandler {

  /**
   * @return {@link ResponseEntity}
   */
  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<Error> userNotFound(
      final UserNotFoundException exception, final WebRequest request) {

    final Error error =
        new Error(false, exception.getMessage(), request.getDescription(false), new Date());
    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }

  /**
   * @return {@link ResponseEntity}
   */
  @ExceptionHandler(UserAlreadyExistsException.class)
  public ResponseEntity<Error> userAlreadyExists(
      final UserAlreadyExistsException exception, final WebRequest request) {

    final Error error =
        new Error(false, exception.getMessage(), request.getDescription(false), new Date());
    return new ResponseEntity<>(error, HttpStatus.OK);
  }

  @ExceptionHandler(InvalidArgumentException.class)
  public ResponseEntity<Error> invalidArguments(
      final InvalidArgumentException exception, final WebRequest request) {

    final Error error =
        new Error(false, exception.getMessage(), request.getDescription(false), new Date());
    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
  }

  /**
   * @return {@link ResponseEntity}
   */
  @ExceptionHandler(Exception.class)
  public ResponseEntity<Error> globalExceptions(
      final Exception exception, final WebRequest request) {

    final Error error =
        new Error(false, exception.getMessage(), request.getDescription(false), new Date());
    return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
