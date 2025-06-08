package com.ahumadamob.todolist.service.jpa;

import java.util.List;
import org.springframework.stereotype.Service;
import com.ahumadamob.todolist.entity.User;
import com.ahumadamob.todolist.repository.UserRepository;
import com.ahumadamob.todolist.service.IUserService;
import com.ahumadamob.todolist.exception.RecordNotFoundException;
import com.ahumadamob.todolist.exception.ValidationException;
import com.ahumadamob.todolist.dto.UserRequestDto;
import com.ahumadamob.todolist.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserServiceJpa implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public User create(UserRequestDto dto) {
        if (userRepository.existsByUsername(dto.getUsername())) {
            throw new ValidationException("Username already exists");
        }
        User user = userMapper.toEntity(dto);
        return userRepository.save(user);
    }

    @Override
    public User update(Long id, UserRequestDto dto) {
        User existing = userRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("User not found"));
        if (!existing.getUsername().equals(dto.getUsername()) &&
                userRepository.existsByUsername(dto.getUsername())) {
            throw new ValidationException("Username already exists");
        }
        userMapper.applyToEntity(dto, existing);
        return userRepository.save(existing);
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
