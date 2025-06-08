package com.ahumadamob.todolist.exception;

public class RecordNotFoundException extends RuntimeException {
    private final String field;

    public RecordNotFoundException(String field, String message) {
        super(message);
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
