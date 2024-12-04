package com.smokedcorn.trainerbot.service;

import com.smokedcorn.trainerbot.domain.Routines;
import com.smokedcorn.trainerbot.repository.RoutinesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class RoutinesService {

    @Autowired
    private final RoutinesRepository routinesRepository;


    public RoutinesService(RoutinesRepository routinesRepository) {
        this.routinesRepository = routinesRepository;
    }

    public Routines addRoutine(String userId, String condition, String target) {
        Routines routine = new Routines();

        routine.setUserId(userId);
        routine.setCondition(condition);
        routine.setTarget(target); // "lower" / upper
        routine.setCreatedAt(LocalDateTime.now());

        routinesRepository.save(routine);

        return routine;
    }

    public String getTarget(String userId) {
        String nowTarget = Optional.ofNullable(routinesRepository.getTarget(userId))
                .orElse("lower");

        if (nowTarget.equals("upper")) {
            return "lower";
        } else {
            return "upper";
        }
    }




}
