package com.example.apidemo.service;

import com.example.apidemo.repository.UserRepository;
import com.example.apidemo.entity.User;
import com.example.apidemo.request.UserCreateRequest;
import com.example.apidemo.request.UserUpdateRequest;
import com.example.apidemo.response.UserResponse;
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

    public List<UserResponse> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserResponse::of)
                .toList();
    }

    public UserResponse getUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User Not Found"));

        return UserResponse.of(user);
    }

    @Transactional
    public User createUser(UserCreateRequest request) {
        User user = User.builder()
                .name(request.getName())
                .description(request.getDescription())
                .build();
        return userRepository.save(user);
    }

    @Transactional
    public void updateUser(Long id, UserUpdateRequest request) {
        User findUser = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User Not Found"));

        findUser.updateDesc(request.getDescription());
    }

    @Transactional
    public void deleteUser(Long id) {
        User findUser = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User Not Found"));

        userRepository.delete(findUser);
    }
}
