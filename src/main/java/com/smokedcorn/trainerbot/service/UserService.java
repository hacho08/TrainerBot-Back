package com.smokedcorn.trainerbot.service;

import com.smokedcorn.trainerbot.domain.User;
import com.smokedcorn.trainerbot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 사용자 이름 저장
    public User addUser(User user) {
        return userRepository.save(user);
    }

    // 사용자 이름 조회
    public User getUserById(Long userId) {
        return userRepository.findById(Long.valueOf(userId)).orElse(null);
    }

}
