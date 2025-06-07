package com.ahumadamob.todolist.service.jpa;

import java.util.List;
import org.springframework.stereotype.Service;
import com.ahumadamob.todolist.entity.User;
import com.ahumadamob.todolist.repository.UserRepository;
import com.ahumadamob.todolist.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserServiceJpa implements IUserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceJpa(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
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
