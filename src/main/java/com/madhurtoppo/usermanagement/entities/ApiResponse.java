package com.madhurtoppo.usermanagement.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

/** Response */
@Data
@AllArgsConstructor
public class ApiResponse {

  private boolean success;
  private String message;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Object data;

  public ApiResponse(boolean status, String message) {
    this.success = status;
    this.message = message;
  }
}
