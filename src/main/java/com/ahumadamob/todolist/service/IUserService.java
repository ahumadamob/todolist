package com.ahumadamob.todolist.service;

import java.util.List;
import com.ahumadamob.todolist.entity.User;

public interface IUserService {
    User save(User user);
    List<User> findAll();
    User findById(Long id);
    void deleteById(Long id);
}
