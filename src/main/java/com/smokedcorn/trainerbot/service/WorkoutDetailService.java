package com.smokedcorn.trainerbot.service;

import com.smokedcorn.trainerbot.domain.WorkoutDetail;
import com.smokedcorn.trainerbot.repository.WorkoutDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkoutDetailService {

    private final WorkoutDetailRepository workoutDetailRepository;

    @Autowired
    public WorkoutDetailService(WorkoutDetailRepository workoutDetailRepository) {
        this.workoutDetailRepository = workoutDetailRepository;
    }

    // 운동 세부 사항 조회
    public Optional<WorkoutDetail> getWorkoutDetailById(String workoutId) {
        return workoutDetailRepository.findById(workoutId);
    }

    // 특정 루틴에 속한 운동 세부 사항 조회
    public List<WorkoutDetail> getWorkoutDetailsByRoutineId(String routineId) {
        return workoutDetailRepository.findByRoutineRoutineId(routineId);
    }

    // 운동 세부 사항 추가
    public WorkoutDetail createWorkoutDetail(WorkoutDetail workoutDetail) {
        return workoutDetailRepository.save(workoutDetail);
    }

    // 운동 세부 사항 수정
    public WorkoutDetail updateWorkoutDetail(WorkoutDetail workoutDetail) {
        return workoutDetailRepository.save(workoutDetail);
    }

    // 운동 세부 사항 삭제
    public void deleteWorkoutDetail(String workoutId) {
        workoutDetailRepository.deleteById(workoutId);
    }
}

