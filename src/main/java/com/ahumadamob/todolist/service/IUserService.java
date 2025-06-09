package com.ahumadamob.todolist.service;

import java.util.List;
import com.ahumadamob.todolist.entity.User;
import com.ahumadamob.todolist.dto.UserRequestDto;

public interface IUserService {
    User create(UserRequestDto dto);
    User update(Long id, UserRequestDto dto);
    List<User> findAll();
    User findById(Long id);
    void deleteById(Long id);
}
