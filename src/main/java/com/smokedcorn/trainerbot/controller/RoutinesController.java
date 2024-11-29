package com.smokedcorn.trainerbot.controller;

import com.smokedcorn.trainerbot.domain.Routines;
import com.smokedcorn.trainerbot.service.RoutinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RoutinesController {

    private final RoutinesService routinesService;

    @Autowired
    public RoutinesController(RoutinesService routineService) {
        this.routinesService = routineService;
    }

    @PostMapping("/today_condition")
    public ResponseEntity<String> handleTodayCondition(@RequestBody Routines routines) {
        // 응답 반환
        System.out.println(routines.getCondition());
        System.out.println(routines.getUserId());
        return ResponseEntity.ok("dddd");
    }

}
