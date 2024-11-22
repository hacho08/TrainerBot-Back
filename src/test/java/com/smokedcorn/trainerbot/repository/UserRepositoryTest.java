package com.smokedcorn.trainerbot.repository;

import com.smokedcorn.trainerbot.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void 고객_등록() {
        User user = new User();
        user.setUserId("test");
        user.setBirthYear(1994);
        user.setGender("M");
        user.setGoal("근력강화");
        user.setCreatedAt(LocalDateTime.now());
        user.setWorkoutExperience("초보자");

        User savedUser = userRepository.save(user);

        Assertions.assertThat(savedUser.getUserId()).isEqualTo("test");

    }

}