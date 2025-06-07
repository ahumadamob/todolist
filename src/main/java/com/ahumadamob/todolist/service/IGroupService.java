package com.ahumadamob.todolist.service;

import java.util.List;
import com.ahumadamob.todolist.entity.Group;

public interface IGroupService {
    Group create(Group group);
    Group update(Long id, Group group);
    List<Group> findAll();
    Group findById(Long id);
    void deleteById(Long id);
}
