package com.dentist.ProjectDentist.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptions {

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<String> ProgressErrorBadRequest(BadRequestException x){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(x.getMessage());
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<String> ResourceNotFound(ResourceNotFoundException x){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(x.getMessage());
    }
}
