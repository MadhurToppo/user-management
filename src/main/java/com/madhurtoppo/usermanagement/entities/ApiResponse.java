package com.madhurtoppo.usermanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/** Response */
@Getter
@Setter
@AllArgsConstructor
public class ApiResponse {

  private boolean status;
  private String message;
  private Object data;
}
