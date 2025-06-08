package com.ahumadamob.todolist.service.jpa;

import java.util.List;
import org.springframework.stereotype.Service;
import com.ahumadamob.todolist.entity.Group;
import com.ahumadamob.todolist.repository.GroupRepository;
import com.ahumadamob.todolist.service.IGroupService;
import com.ahumadamob.todolist.exception.RecordNotFoundException;
import com.ahumadamob.todolist.dto.GroupRequestDto;
import com.ahumadamob.todolist.mapper.GroupMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class GroupServiceJpa implements IGroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private GroupMapper groupMapper;

    @Override
    public Group create(GroupRequestDto dto) {
        Group group = groupMapper.toEntity(dto);
        return groupRepository.save(group);
    }

    @Override
    public Group update(Long id, GroupRequestDto dto) {
        Group existing = groupRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Grupo no encontrado"));
        groupMapper.applyToEntity(dto, existing);
        return groupRepository.save(existing);
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
