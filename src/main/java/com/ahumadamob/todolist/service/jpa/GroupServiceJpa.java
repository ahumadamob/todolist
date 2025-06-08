package com.ahumadamob.todolist.service.jpa;

import java.util.List;
import org.springframework.stereotype.Service;
import com.ahumadamob.todolist.entity.Group;
import com.ahumadamob.todolist.repository.GroupRepository;
import com.ahumadamob.todolist.service.IGroupService;
import com.ahumadamob.todolist.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class GroupServiceJpa implements IGroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public Group create(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public Group update(Long id, Group group) {
        Group existing = groupRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Group not found"));
        group.setId(existing.getId());
        return groupRepository.save(group);
    }

    @Override
    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    @Override
    public Group findById(Long id) {
        return groupRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        groupRepository.deleteById(id);
    }
}
