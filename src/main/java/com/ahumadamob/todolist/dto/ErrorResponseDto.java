package com.ahumadamob.todolist.dto;

import java.util.List;

/**
 * Simple DTO representing an error response with a list of messages.
 */
public class ErrorResponseDto {
    private List<String> messages;

    public ErrorResponseDto() {
    }

    public ErrorResponseDto(List<String> messages) {
        this.messages = messages;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
}
