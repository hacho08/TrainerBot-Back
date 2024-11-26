package com.smokedcorn.trainerbot.controller;

import com.smokedcorn.trainerbot.domain.User;
import com.smokedcorn.trainerbot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8090")  // 요청하는 도메인 허용
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // POST: 사용자 이름 추가
    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User createdUser = userService.addUser(user);  // 사용자 이름 저장
        return ResponseEntity.ok(createdUser);  // 저장된 사용자 반환
    }

    // GET: 사용자 이름 조회
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    }

