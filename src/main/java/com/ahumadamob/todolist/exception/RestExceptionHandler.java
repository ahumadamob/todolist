package com.ahumadamob.todolist.exception;

import java.util.Collections;
import java.util.List;
import java.sql.SQLIntegrityConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;

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
        ErrorDetailDto detail = new ErrorDetailDto(ex.getField(), ex.getMessage());
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
        ErrorDetailDto detail = new ErrorDetailDto(ex.getField(), ex.getMessage());
        ErrorResponseDto dto = new ErrorResponseDto(Collections.singletonList(detail));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<ErrorResponseDto> handleSqlIntegrityViolation(SQLIntegrityConstraintViolationException ex) {
        ErrorDetailDto detail = new ErrorDetailDto("id", "El registro no puede ser eliminado porque está en uso");
        ErrorResponseDto dto = new ErrorResponseDto(Collections.singletonList(detail));
        return ResponseEntity.status(HttpStatus.CONFLICT).body(dto);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponseDto> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        if (ex.getRootCause() instanceof SQLIntegrityConstraintViolationException sqlEx) {
            return handleSqlIntegrityViolation(sqlEx);
        }
        ErrorDetailDto detail = new ErrorDetailDto("id", "Violación de integridad de datos");
        ErrorResponseDto dto = new ErrorResponseDto(Collections.singletonList(detail));
        return ResponseEntity.status(HttpStatus.CONFLICT).body(dto);
    }
}
