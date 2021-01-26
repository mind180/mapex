package com.roadmapex.roadmapex.config.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler({ ApiException.class })
  protected ResponseEntity<Object> handleApiError(ApiException ex, WebRequest request) {
    ApiExceptionDto apiExceptionDto = new ApiExceptionDto(ex);

    return new ResponseEntity<>(apiExceptionDto, ex.getStatus());
  }
}
