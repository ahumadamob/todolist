package com.ahumadamob.todolist.exception;

import java.util.Collections;
import java.util.List;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import jakarta.validation.ConstraintViolationException;

import com.ahumadamob.todolist.dto.ErrorDetailDto;
import com.ahumadamob.todolist.dto.ErrorResponseDto;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleRecordNotFound(RecordNotFoundException ex) {
        ErrorDetailDto detail = new ErrorDetailDto(null, ex.getMessage());
        ErrorResponseDto dto = new ErrorResponseDto(Collections.singletonList(detail));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDto> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        List<ErrorDetailDto> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(fe -> new ErrorDetailDto(fe.getField(), fe.getDefaultMessage()))
                .toList();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponseDto(errors));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponseDto> handleConstraintViolation(ConstraintViolationException ex) {
        List<ErrorDetailDto> errors = ex.getConstraintViolations().stream()
                .map(cv -> new ErrorDetailDto(cv.getPropertyPath().toString(), cv.getMessage()))
                .toList();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponseDto(errors));
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorResponseDto> handleValidationException(ValidationException ex) {
        ErrorDetailDto detail = new ErrorDetailDto(null, ex.getMessage());
        ErrorResponseDto dto = new ErrorResponseDto(Collections.singletonList(detail));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
    }
}
