package com.ahumadamob.todolist.dto;

/**
 * DTO representing an individual error detail.
 * Contains the field associated with the error (if any) and the message.
 */
public class ErrorDetailDto {
    private String field;
    private String value;

    public ErrorDetailDto() {
    }

    public ErrorDetailDto(String field, String value) {
        this.field = field;
        this.value = value;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
