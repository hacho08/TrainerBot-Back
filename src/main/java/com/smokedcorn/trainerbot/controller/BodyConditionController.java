package com.smokedcorn.trainerbot.controller;

import com.smokedcorn.trainerbot.service.BodyConditionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8090")  // 요청하는 도메인 허용
@RestController
@RequestMapping("/api/body_condition")
public class BodyConditionController {

    private final BodyConditionsService bodyConditionsService;

    @Autowired
    public BodyConditionController(BodyConditionsService bodyConditionsService) {
        this.bodyConditionsService = bodyConditionsService;
    }

    // GET: 사용자 이름 조회@GetMapping("/")
    ////    public ResponseEntity<BodyConditions> getUserById(@PathVariable Long userId) {
    ////        BodyConditions bodyConditions = bodyConditionsService.getBodyConditionById(userId);
    ////        if (bodyConditions != null) {
    ////            return ResponseEntity.ok(bodyConditions);
    ////        } else {
    ////            return ResponseEntity.notFound().build();
    ////        }
    ////    }
//
    }

