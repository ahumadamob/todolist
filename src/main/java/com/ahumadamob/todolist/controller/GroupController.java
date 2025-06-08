package com.ahumadamob.todolist.controller;

import java.util.List;
import java.util.Collections;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahumadamob.todolist.dto.ErrorResponseDto;
import com.ahumadamob.todolist.dto.SuccessResponseDto;
import com.ahumadamob.todolist.entity.Group;
import com.ahumadamob.todolist.service.IGroupService;
import com.ahumadamob.todolist.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/groups")
public class GroupController {
    @Autowired
    private IGroupService groupService;

    @GetMapping
    public ResponseEntity<SuccessResponseDto<List<Group>>> findAll() {
        List<Group> groups = groupService.findAll();
        return ResponseEntity.ok(new SuccessResponseDto<>("Groups retrieved", groups));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Group group = groupService.findById(id);
        if (group == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponseDto(Collections.singletonList("Group not found")));
        }
        return ResponseEntity.ok(new SuccessResponseDto<>("Group found", group));
    }

    @PostMapping
    public ResponseEntity<SuccessResponseDto<Group>> create(@Valid @RequestBody Group group) {
        Group saved = groupService.create(group);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessResponseDto<>("Group created", saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody Group group) {
        try {
            Group saved = groupService.update(id, group);
            return ResponseEntity.ok(new SuccessResponseDto<>("Group updated", saved));
        } catch (RecordNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponseDto(Collections.singletonList(e.getMessage())));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponseDto<Void>> delete(@PathVariable Long id) {
        groupService.deleteById(id);
        return ResponseEntity.ok(new SuccessResponseDto<>("Group deleted", null));
    }
}
