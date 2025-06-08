package com.ahumadamob.todolist.service.jpa;

import java.util.List;
import org.springframework.stereotype.Service;
import com.ahumadamob.todolist.entity.User;
import com.ahumadamob.todolist.repository.UserRepository;
import com.ahumadamob.todolist.service.IUserService;
import com.ahumadamob.todolist.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserServiceJpa implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(Long id, User user) {
        User existing = userRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("User not found"));
        user.setId(existing.getId());
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
