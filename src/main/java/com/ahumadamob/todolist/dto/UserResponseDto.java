package com.ahumadamob.todolist.dto;

/**
 * DTO enviado al cliente para representar un usuario.
 * No expone el campo de contraseña.
 */
public class UserResponseDto {
    private Long id;
    private String username;
    private GroupResponseDto group;

    public UserResponseDto() {
    }

    public UserResponseDto(Long id, String username, GroupResponseDto group) {
        this.id = id;
        this.username = username;
        this.group = group;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public GroupResponseDto getGroup() {
        return group;
    }

    public void setGroup(GroupResponseDto group) {
        this.group = group;
    }
}
