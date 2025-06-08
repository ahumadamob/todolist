package com.ahumadamob.todolist.service;

import java.util.List;
import com.ahumadamob.todolist.entity.Group;
import com.ahumadamob.todolist.dto.GroupRequestDto;

public interface IGroupService {
    Group create(GroupRequestDto dto);
    Group update(Long id, GroupRequestDto dto);
    List<Group> findAll();
    Group findById(Long id);
    void deleteById(Long id);
}
