package com.smokedcorn.trainerbot.controller;

import com.smokedcorn.trainerbot.service.RoutinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/routines")
public class RoutinesController {

    private final RoutinesService routinesService;

    @Autowired
    public RoutinesController(RoutinesService routineService) {
        this.routinesService = routineService;
    }

//    @PostMapping
//    public ResponseEntity<Routines> createRoutine(
//            @RequestParam String userId,
//            @RequestParam String condition,
//            @RequestParam String target) {
//        Routines routine = routinesService.createRoutine(userId, condition, target);
//        return ResponseEntity.ok(routine); // 저장된 데이터를 반환
//    }
}
