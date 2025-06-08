package com.ahumadamob.todolist.dto;

/**
 * DTO utilizado para crear o actualizar un grupo.
 */
public class GroupRequestDto {
    private String name;

    public GroupRequestDto() {
    }

    public GroupRequestDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
