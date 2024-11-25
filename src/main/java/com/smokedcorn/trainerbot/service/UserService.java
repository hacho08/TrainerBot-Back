package com.smokedcorn.trainerbot.service;

import com.smokedcorn.trainerbot.domain.User;
import com.smokedcorn.trainerbot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 사용자 조회
    public Optional<User> getUserById(String userId) {
        return userRepository.findById(Long.valueOf(userId));
    }

    // 사용자 추가
    public User addUser(User user) {
        return userRepository.save(user);
    }

    // 사용자 수정
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    // 사용자 삭제
    public void deleteUser(String userId) {
        userRepository.deleteById(Long.valueOf(userId));
    }
}
