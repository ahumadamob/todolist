package com.ahumadamob.todolist.mapper;

import org.springframework.stereotype.Component;

import com.ahumadamob.todolist.dto.GroupRequestDto;
import com.ahumadamob.todolist.dto.GroupResponseDto;
import com.ahumadamob.todolist.entity.Group;

@Component
public class GroupMapper {

    public Group toEntity(GroupRequestDto dto) {
        Group group = new Group();
        applyToEntity(dto, group);
        return group;
    }

    public void applyToEntity(GroupRequestDto dto, Group group) {
        group.setName(dto.getName());
    }

    public GroupResponseDto toDto(Group group) {
        return new GroupResponseDto(group.getId(), group.getName());
    }
}
