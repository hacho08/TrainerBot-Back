package com.smokedcorn.trainerbot.repository;

import com.smokedcorn.trainerbot.domain.WorkoutDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkoutDetailRepository extends JpaRepository<WorkoutDetail, String> {
    // 기본적인 CRUD 작업은 JpaRepository가 자동으로 처리합니다.

    // 예시: 특정 Routine에 속한 WorkoutDetail들을 찾는 메서드
    List<WorkoutDetail> findByRoutineRoutineId(String routineId);

    // 예시: 특정 WorkoutOrder로 WorkoutDetail 찾기
    List<WorkoutDetail> findByWorkoutOrder(Integer workoutOrder);
}

