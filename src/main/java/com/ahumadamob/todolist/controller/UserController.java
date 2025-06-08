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
import com.ahumadamob.todolist.dto.UserRequestDto;
import com.ahumadamob.todolist.dto.UserResponseDto;
import com.ahumadamob.todolist.entity.User;
import com.ahumadamob.todolist.service.IUserService;
import com.ahumadamob.todolist.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService userService;

    @Autowired
    private UserMapper userMapper;

    @GetMapping
    public ResponseEntity<SuccessResponseDto<List<UserResponseDto>>> findAll() {
        List<User> users = userService.findAll();
        List<UserResponseDto> dtos = users.stream()
                .map(userMapper::toDto)
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
        return ResponseEntity.ok(new SuccessResponseDto<>("User found", userMapper.toDto(user)));
    }

    @PostMapping
    public ResponseEntity<SuccessResponseDto<UserResponseDto>> create(@Valid @RequestBody UserRequestDto dto) {
        User saved = userService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessResponseDto<>("User created", userMapper.toDto(saved)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuccessResponseDto<UserResponseDto>> update(@PathVariable Long id, @Valid @RequestBody UserRequestDto dto) {
        User saved = userService.update(id, dto);
        return ResponseEntity.ok(new SuccessResponseDto<>("User updated", userMapper.toDto(saved)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponseDto<Void>> delete(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok(new SuccessResponseDto<>("User deleted", null));
    }

}
