package com.ciTask.exception;

import com.ciTask.dictionary.APIErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InspireException.class)
    public ResponseEntity<ErrorResponse> handleInspireException(InspireException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode().name(), ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
