package com.ahumadamob.todolist.service;

import java.util.List;
import com.ahumadamob.todolist.entity.User;

public interface IUserService {
    User create(User user);
    User update(Long id, User user);
    List<User> findAll();
    User findById(Long id);
    void deleteById(Long id);
}
