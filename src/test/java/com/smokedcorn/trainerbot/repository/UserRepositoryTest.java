package com.smokedcorn.trainerbot.repository;

import com.smokedcorn.trainerbot.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void 고객_등록() {
        User user = new User();
        user.setUserId("01011112222");
        user.setUserName("조현아");
        user.setBirthYear(1998);
        user.setGender("여자");
        user.setGoal("근력강화,체중감량");
        user.setCreatedAt(LocalDateTime.now());
        user.setWorkoutExperience("초급자");

        User savedUser = userRepository.save(user);

//        Assertions.assertThat(savedUser.getUserId()).isEqualTo("test");

    }

    @Test
    void 고객_조회() {

        User user = userRepository.findById("01041410402").orElse(null);
        System.out.println("결과값: " + user + user.getUserName());


    }
}