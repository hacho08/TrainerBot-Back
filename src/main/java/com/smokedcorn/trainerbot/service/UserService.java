package com.smokedcorn.trainerbot.service;

import com.smokedcorn.trainerbot.domain.User;
import com.smokedcorn.trainerbot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;
    private DataConversionService dataConversionService;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.dataConversionService = dataConversionService;
    }

    // 사용자 이름 저장
    public User addUser(User user) {
        return userRepository.save(user);
    }

    // 사용자 이름 조회
    public User getUserById(String userId) {
        return userRepository.findById(userId).orElse(null);
    }

    // 단일 사용자의 상세 정보를 가져오는 메서드 (bCondName, hobbyName 최대 2개 처리)
//    public User getUserWithDetails(String userId) {
//        List<Object[]> results = userRepository.findUserWithDetails(userId);
//        User user = null;
//
//        List<String> conditions = new ArrayList<>(); // 최대 2개의 컨디션 이름 저장
//        List<String> hobbies = new ArrayList<>();    // 최대 2개의 취미 이름 저장
//
//        for (Object[] result : results) {
//            if (user == null) {
//                user = (User) result[0]; // 첫 번째 User 객체 가져오기
//            }
//
//            // Body Condition Name
//            String bCondName = (String) result[1];
//            if (bCondName != null && conditions.size() < 2 && !conditions.contains(bCondName)) {
//                conditions.add(bCondName);
//            }
//
//            // Hobby Name
//            String hobbyName = (String) result[2];
//            if (hobbyName != null && hobbies.size() < 2 && !hobbies.contains(hobbyName)) {
//                hobbies.add(hobbyName);
//            }
//
//            // 최대 두 개씩만 처리
//            if (conditions.size() >= 2 && hobbies.size() >= 2) {
//                break;
//            }
//        }
//
//        // Transient 필드 설정
//        if (user != null) {
//            user.setBCondName(String.join(", ", conditions)); // 여러 컨디션 이름을 콤마로 연결
//            user.setHobbyName(String.join(", ", hobbies));    // 여러 취미 이름을 콤마로 연결
//        }
//
//        return user;
//    }

    public void saveUserDetails(String userId, List<Integer> conditionIndices, List<Integer> hobbyIndices, List<Integer> goalIndices) {
        // 인덱스를 텍스트로 변환
        List<String> conditions = dataConversionService.convertConditionIndicesToText(conditionIndices);
        List<String> hobbies = dataConversionService.convertHobbyIndicesToText(hobbyIndices);
        List<String> goals = dataConversionService.convertGoalIndicesToText(goalIndices);

        // 사용자 데이터 저장 로직
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));

        user.setBCondName(String.join(", ", conditions));
        user.setHobbyName(String.join(", ", hobbies));
        user.setGoal(String.join(", ", goals));

        userRepository.save(user);
    }
}
