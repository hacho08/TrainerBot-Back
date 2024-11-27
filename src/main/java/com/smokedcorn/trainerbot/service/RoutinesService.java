package com.smokedcorn.trainerbot.service;

import com.smokedcorn.trainerbot.domain.Routines;
import com.smokedcorn.trainerbot.repository.RoutinesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public Routines createRoutine(String userId, String condition, String target) {
        Routines routine = new Routines();
        routine.setRoutineId(UUID.randomUUID().toString()); // UUID로 고유 ID 생성
        routine.setUserId(userId);
        routine.setCondition(condition);
        routine.setTarget(target);
        routine.setCreatedAt(LocalDateTime.from(LocalDate.now())); // 현재 날짜 설정

        return routinesRepository.save(routine); // 데이터베이스에 저장
    }
}
