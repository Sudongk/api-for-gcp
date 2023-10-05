package com.example.apidemo.service;

import com.example.apidemo.repository.UserRepository;
import com.example.apidemo.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User Not Found"));
    }

    @Transactional
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public void updateUser(Long id, User user) {
        User findUser = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User Not Found"));

        findUser.updateDesc(user.getDescription());
    }

    @Transactional
    public void deleteUser(Long id) {
        User findUser = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User Not Found"));

        userRepository.delete(findUser);
    }
}
