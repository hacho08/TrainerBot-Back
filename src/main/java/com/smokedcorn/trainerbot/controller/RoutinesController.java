package com.smokedcorn.trainerbot.controller;

import com.smokedcorn.trainerbot.domain.*;
import com.smokedcorn.trainerbot.service.BodyConditionsService;
import com.smokedcorn.trainerbot.service.HobbyService;
import com.smokedcorn.trainerbot.service.RoutinesService;
import com.smokedcorn.trainerbot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RoutinesController {

    private final RoutinesService routinesService;
    private final UserService userService;
    private final HobbyService hobbyService;
    private final BodyConditionsService bodyConditionsService;

    @Autowired
    public RoutinesController(RoutinesService routineService, UserService userService, HobbyService hobbyService, BodyConditionsService bodyConditionsService) {
        this.routinesService = routineService;
        this.userService = userService;
        this.hobbyService = hobbyService;
        this.bodyConditionsService = bodyConditionsService;
    }

    @PostMapping("/today_condition")
    public ResponseEntity<Routines> addRoutine(@RequestBody Routines routines) {
        // 응답 반환
        System.out.println(routines.getCondition());
        System.out.println(routines.getUserId());

        // 마지막 운동이 뭐였는지 확인
        String target = routinesService.getTarget(routines.getUserId());

        Routines addedRoutine = routinesService.addRoutine(routines.getUserId(), routines.getCondition(), target);
//        if (addedRoutine != null) {
            return ResponseEntity.ok(addedRoutine);
//        } else {
//            return ResponseEntity.notFound().build();
//        }



    }

    @PostMapping("/getWorkouts")
    public ResponseEntity<List<WorkoutDetail>> getWorkouts(@RequestBody Routines routines) {
        // 응답 반환
        System.out.println("getWorkouts called");
        User user = userService.getUserById(routines.getUserId());
        List<UserHobby> userHobbies = hobbyService.getAllHobbies(routines.getUserId());
        Optional<UserBodyConditions> userBodyConditions = bodyConditionsService.getBodyConditionById(routines.getUserId());
        System.out.println( "user!!!!!!!!!" + user);
        System.out.println("userHobbies "+userHobbies);
        System.out.println("userbodyConditions" + userBodyConditions);

        List<WorkoutDetail> workoutDetails = new ArrayList<>();

//        if (addedRoutine != null) {
        return ResponseEntity.ok(workoutDetails);
//        } else {
//            return ResponseEntity.notFound().build();
//        }



    }
}
