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
import com.ahumadamob.todolist.dto.GroupResponseDto;
import com.ahumadamob.todolist.dto.UserRequestDto;
import com.ahumadamob.todolist.dto.UserResponseDto;
import com.ahumadamob.todolist.entity.User;
import com.ahumadamob.todolist.entity.Group;
import com.ahumadamob.todolist.service.IUserService;
import com.ahumadamob.todolist.service.IGroupService;
import com.ahumadamob.todolist.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService userService;

    @Autowired
    private IGroupService groupService;

    @GetMapping
    public ResponseEntity<SuccessResponseDto<List<UserResponseDto>>> findAll() {
        List<User> users = userService.findAll();
        List<UserResponseDto> dtos = users.stream()
                .map(this::toDto)
                .toList();
        return ResponseEntity.ok(new SuccessResponseDto<>("Users retrieved", dtos));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        User user = userService.findById(id);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponseDto(Collections.singletonList("User not found")));
        }
        return ResponseEntity.ok(new SuccessResponseDto<>("User found", toDto(user)));
    }

    @PostMapping
    public ResponseEntity<SuccessResponseDto<UserResponseDto>> create(@Valid @RequestBody UserRequestDto dto) {
        User user = toEntity(dto);
        User saved = userService.create(user);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessResponseDto<>("User created", toDto(saved)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuccessResponseDto<UserResponseDto>> update(@PathVariable Long id, @Valid @RequestBody UserRequestDto dto) {
        User user = toEntity(dto);
        User saved = userService.update(id, user);
        return ResponseEntity.ok(new SuccessResponseDto<>("User updated", toDto(saved)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponseDto<Void>> delete(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok(new SuccessResponseDto<>("User deleted", null));
    }

    private UserResponseDto toDto(User user) {
        GroupResponseDto groupDto = null;
        if (user.getGroup() != null) {
            groupDto = new GroupResponseDto(user.getGroup().getId(), user.getGroup().getName());
        }
        return new UserResponseDto(user.getId(), user.getUsername(), groupDto);
    }

    private User toEntity(UserRequestDto dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        if (dto.getGroupId() != null) {
            Group group = groupService.findById(dto.getGroupId());
            if (group == null) {
                throw new RecordNotFoundException("Group not found");
            }
            user.setGroup(group);
        }
        return user;
    }
}
