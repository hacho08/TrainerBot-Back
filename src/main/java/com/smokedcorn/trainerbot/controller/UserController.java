package com.smokedcorn.trainerbot.controller;

import com.smokedcorn.trainerbot.controller.dto.UserInfoDTO;
import com.smokedcorn.trainerbot.domain.User;
import com.smokedcorn.trainerbot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@CrossOrigin(origins = "http://localhost:8090")  // 요청하는 도메인 허용
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // POST: 사용자 이름 추가
    @PostMapping("/join")
    public ResponseEntity<User> addUser(@RequestBody UserInfoDTO userInfoDTO) {
        User user = new User();
        user.setUserId(userInfoDTO.getUserId());
        user.setUserName(userInfoDTO.getUserName());
        user.setBirthYear(userInfoDTO.getBirthYear());
        user.setGender(userInfoDTO.getGender());
        user.setWorkoutExperience(userInfoDTO.getWorkoutExperience());
        user.setGoal(userInfoDTO.getGoal());
        user.setCreatedAt(userInfoDTO.getCreatedAt());
        List<Integer>  bodyConditionIds = userInfoDTO.getBodyConditionIds();
        List<Integer>  hobby = userInfoDTO.getHobby();
        System.out.println("!!!!!!!!!!user: "+ user + " condition " + bodyConditionIds + " hobby " +hobby );
        User createdUser = userService.addUser(user, bodyConditionIds , hobby);  // 사용자 이름 저장
        return ResponseEntity.ok(createdUser);  // 저장된 사용자 반환
    }

    // POST: 사용자 이름 조회
    @PostMapping("/login")
    public ResponseEntity<User> getUserById(@RequestBody String userId) {

        System.out.println(userId);

        User user = userService.getUserById(userId);

        System.out.println("END");

        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    // UserController.java
    @PostMapping("/getUserInfo")
    public ResponseEntity<?> getUserInfo(@RequestBody Map<String, String> request) {
        try {
            String userId = request.get("userId");
            if (userId == null || userId.isEmpty()) {
                return ResponseEntity.badRequest().body("User ID is required");
            }

            User user = userService.getUserById(userId);
            if (user != null) {
                Map<String, String> response = new HashMap<>();
                response.put("userName", user.getUserName());
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error retrieving user info: " + e.getMessage());
        }
    }


    // GET: 단일 사용자의 상세 정보 조회 (bCondName, hobbyName 포함)
//    @PostMapping("/join")
//    public ResponseEntity<User> getUserDetails(@RequestBody String userId) {
//        User user = userService.getUserWithDetails(userId); // UserService에서 getUserWithDetails 호출
//        if (user != null) {
//            return ResponseEntity.ok(user); // 사용자 데이터 반환
//        } else {
//            return ResponseEntity.notFound().build(); // 404 Not Found 반환
//        }
//    }

//    // POST: 사용자 상세 데이터 저장 (취미, 컨디션, 운동 목표)
//    @PostMapping("/{userId}/save-details")
//    public ResponseEntity<Void> saveUserDetails(
//            @PathVariable String userId,
//            @RequestBody UserDetailsRequest request) {
//
//        userService.saveUserDetails(
//                userId,
//                request.getConditionIndices(),
//                request.getHobbyIndices(),
//                request.getGoalIndices()
//        );
//
//        return ResponseEntity.ok().build();
//    }

    }

