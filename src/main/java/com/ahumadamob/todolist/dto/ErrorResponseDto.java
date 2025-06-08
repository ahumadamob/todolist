package com.ahumadamob.todolist.dto;

import java.util.List;
import com.ahumadamob.todolist.dto.ErrorDetailDto;

/**
 * Simple DTO representing an error response with a list of messages.
 */
public class ErrorResponseDto {
    private List<ErrorDetailDto> messages;

    public ErrorResponseDto() {
    }

    public ErrorResponseDto(List<ErrorDetailDto> messages) {
        this.messages = messages;
    }

    public List<ErrorDetailDto> getMessages() {
        return messages;
    }

    public void setMessages(List<ErrorDetailDto> messages) {
        this.messages = messages;
    }
}
