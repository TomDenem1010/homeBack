package com.home.play.spring;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(value = { RuntimeException.class })
    protected ResponseEntity<Object> handleConflict(
      RuntimeException exception, WebRequest request) {
        String bodyOfResponse = exception.getMessage();
        System.out.println("--------------");
        System.out.println(bodyOfResponse);
        System.out.println("--------------");
        return new ResponseEntity<Object>(
            bodyOfResponse, HttpStatus.FORBIDDEN);
    }
}
