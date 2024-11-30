package com.smokedcorn.trainerbot.repository;

import com.smokedcorn.trainerbot.domain.Routines;
import com.smokedcorn.trainerbot.domain.User;
import com.smokedcorn.trainerbot.service.RoutinesService;
import com.smokedcorn.trainerbot.service.UserService;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class RoutineRepositoryTest {

    @Autowired
    RoutinesRepository routinesRepository;


    @Test
    void 루틴_등록() {

        Routines routines = new Routines();
        routines.setRoutineId("0");
        routines.setUserId("01011112222");
        routines.setCondition("easy");
        routines.setTarget("upper");
        routines.setCreatedAt(LocalDateTime.now());

        routinesRepository.save(routines);


//        Assertions.assertThat(savedUser.getUserId()).isEqualTo("test");

    }

}