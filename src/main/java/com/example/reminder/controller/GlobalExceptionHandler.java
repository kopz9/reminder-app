package com.example.reminder.controller;

import com.example.reminder.domain.dto.ErrorDTO;
import com.example.reminder.exception.TaskNotFoundException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.UUID;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorDTO> handleValidationExceptions(MethodArgumentNotValidException ex) {
    String errorMessage = ex.getBindingResult().getFieldErrors().stream()
        .findFirst()
        .map(DefaultMessageSourceResolvable::getDefaultMessage)
        .orElse("Validation Failed");

    ErrorDTO errorDTO = new ErrorDTO(errorMessage);
    return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
  }

  public ResponseEntity<ErrorDTO> handleTaskNotFoundException(TaskNotFoundException ex) {
    UUID taskNotFoundId = ex.getId();
    String errorMessage = String.format("Task with ID '%s' not found.", taskNotFoundId);
    var errorDTO = new ErrorDTO(errorMessage);
    return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
  }


}
