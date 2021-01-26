package com.roadmapex.roadmapex.config.exceptions;

import com.roadmapex.roadmapex.config.exceptions.ApiException;
import org.springframework.http.HttpStatus;

import java.util.List;

public class ApiExceptionDto {
  private HttpStatus status;
  private String message;
  private List<String> errors;

  public ApiExceptionDto(ApiException ex) {
    this.status = ex.getStatus();
    this.message = ex.getMessage();
    this.errors = ex.getErrors();
  }

  public ApiExceptionDto(HttpStatus status, String message, List<String> errors) {
    this.status = status;
    this.message = message;
    this.errors = errors;
  }

  public HttpStatus getStatus() {
    return status;
  }

  public void setStatus(HttpStatus status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public List<String> getErrors() {
    return errors;
  }

  public void setErrors(List<String> errors) {
    this.errors = errors;
  }
}
