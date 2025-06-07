package com.ahumadamob.todolist.dto;


/**
 * Wrapper used to send a successful operation result to the client.
 */
public class SuccessResponseDto<T> {
    private String message;
    private T data;

    public SuccessResponseDto() {
    }

    public SuccessResponseDto(String message, T data) {
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
