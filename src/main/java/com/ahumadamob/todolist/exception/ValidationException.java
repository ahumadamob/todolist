package com.ahumadamob.todolist.exception;

/**
 * Exception thrown when validation rules are violated.
 */
public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}
