package com.ahumadamob.todolist.dto;

/**
 * DTO utilizado para crear o actualizar un usuario. Se
 * indica el id del grupo asociado.
 */
public class UserRequestDto {
    private String username;
    private String password;
    private Long groupId;

    public UserRequestDto() {
    }

    public UserRequestDto(String username, String password, Long groupId) {
        this.username = username;
        this.password = password;
        this.groupId = groupId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
}
