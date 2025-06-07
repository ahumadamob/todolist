package com.ahumadamob.todolist.service.jpa;

import java.util.List;
import org.springframework.stereotype.Service;
import com.ahumadamob.todolist.entity.Group;
import com.ahumadamob.todolist.repository.GroupRepository;
import com.ahumadamob.todolist.service.IGroupService;

@Service
public class GroupServiceJpa implements IGroupService {

    private final GroupRepository groupRepository;

    public GroupServiceJpa(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public Group save(Group group) {
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
