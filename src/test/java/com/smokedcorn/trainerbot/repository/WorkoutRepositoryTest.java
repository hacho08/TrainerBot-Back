package com.smokedcorn.trainerbot.repository;

import com.smokedcorn.trainerbot.domain.Routines;
import com.smokedcorn.trainerbot.domain.WorkoutDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class WorkoutRepositoryTest {

    @Autowired
    WorkoutDetailRepository workoutDetailRepository;


    @Test
    void 운동_등록() {

        WorkoutDetail workoutDetail = new WorkoutDetail();
        workoutDetail.setWorkoutId("0");
        workoutDetail.setWorkoutName("standingKneeUp");
        workoutDetail.setRoutineId("0");
        workoutDetail.setSetCount(1);
        workoutDetail.setIsCount(1);
        workoutDetail.setRestTime(10);
        workoutDetail.setWorkoutCount(7);
        workoutDetail.setWorkoutOrder(1);


        workoutDetailRepository.save(workoutDetail);



//        Assertions.assertThat(savedUser.getUserId()).isEqualTo("test");

    }

}