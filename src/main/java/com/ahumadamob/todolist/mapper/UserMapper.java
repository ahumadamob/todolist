package com.ahumadamob.todolist.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ahumadamob.todolist.dto.GroupResponseDto;
import com.ahumadamob.todolist.dto.UserRequestDto;
import com.ahumadamob.todolist.dto.UserResponseDto;
import com.ahumadamob.todolist.entity.Group;
import com.ahumadamob.todolist.entity.User;
import com.ahumadamob.todolist.exception.RecordNotFoundException;
import com.ahumadamob.todolist.repository.GroupRepository;

@Component
public class UserMapper {

    @Autowired
    private GroupRepository groupRepository;

    public User toEntity(UserRequestDto dto) {
        User user = new User();
        applyToEntity(dto, user);
        return user;
    }

    public void applyToEntity(UserRequestDto dto, User user) {
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());

        if (dto.getGroupId() != null) {
            Group group = groupRepository.findById(dto.getGroupId())
                    .orElseThrow(() -> new RecordNotFoundException("groupId", "Grupo no encontrado"));
            user.setGroup(group);
        } else {
            user.setGroup(null);
        }
    }

    public UserResponseDto toDto(User user) {
        GroupResponseDto groupDto = null;
        if (user.getGroup() != null) {
            groupDto = new GroupResponseDto(user.getGroup().getId(), user.getGroup().getName());
        }
        return new UserResponseDto(user.getId(), user.getUsername(), groupDto);
    }
}
