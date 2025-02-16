package com.estudo.project.domain.handler;

import com.estudo.project.exceptions.DuplicatePlaceException;
import com.estudo.project.exceptions.PlaceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DuplicatePlaceException.class)
    private ResponseEntity<String> duplicatePlace(DuplicatePlaceException exception){

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler(PlaceNotFoundException.class)
    private ResponseEntity<String> placeNotFound(PlaceNotFoundException exception) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
}
