package com.ahumadamob.todolist.service;

import java.util.List;
import com.ahumadamob.todolist.entity.Group;

public interface IGroupService {
    Group save(Group group);
    List<Group> findAll();
    Group findById(Long id);
    void deleteById(Long id);
}
