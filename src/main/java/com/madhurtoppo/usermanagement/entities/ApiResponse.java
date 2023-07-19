package com.madhurtoppo.usermanagement.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

/** Response */
@Data
@AllArgsConstructor
public class ApiResponse {

  private boolean status;
  private String message;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Object data;

  public ApiResponse(boolean status, String message) {
    this.status = status;
    this.message = message;
  }
}
