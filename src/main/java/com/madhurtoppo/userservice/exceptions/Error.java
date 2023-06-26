package com.madhurtoppo.userservice.exceptions;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;

/** ErrorDetails */
@Data
@AllArgsConstructor
public class Error {
  private String message;
  private String details;
  private Date timestamp;
}
