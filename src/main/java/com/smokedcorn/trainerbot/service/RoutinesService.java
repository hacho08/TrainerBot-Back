package com.smokedcorn.trainerbot.service;

import com.smokedcorn.trainerbot.domain.Routines;
import com.smokedcorn.trainerbot.repository.RoutinesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoutinesService {

    private final RoutinesRepository routinesRepository;

    @Autowired
    public RoutinesService(RoutinesRepository routineRepository) {
        this.routinesRepository = routineRepository;
    }

    // 루틴 조회
    public Optional<Routines> getRoutineById(String routineId) {
        return routinesRepository.findById(routineId);
    }

    // 특정 사용자의 모든 루틴 조회
    public List<Routines> getRoutinesByUserId(String userId) {
        return routinesRepository.findByUserUserId(userId);
    }

    // 루틴 추가
    public Routines createRoutine(Routines routine) {
        return routinesRepository.save(routine);
    }

    // 루틴 수정
    public Routines updateRoutine(Routines routine) {
        return routinesRepository.save(routine);
    }

    // 루틴 삭제
    public void deleteRoutine(String routineId) {
        routinesRepository.deleteById(routineId);
    }
}
