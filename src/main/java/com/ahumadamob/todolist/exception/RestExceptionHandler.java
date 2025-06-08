package com.ahumadamob.todolist.exception;

import java.util.Collections;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ahumadamob.todolist.dto.ErrorResponseDto;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleRecordNotFound(RecordNotFoundException ex) {
        ErrorResponseDto dto = new ErrorResponseDto(Collections.singletonList(ex.getMessage()));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
    }
}
