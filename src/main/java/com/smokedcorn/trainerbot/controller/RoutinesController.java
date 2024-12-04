package com.smokedcorn.trainerbot.controller;

import aj.org.objectweb.asm.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smokedcorn.trainerbot.domain.*;
import com.smokedcorn.trainerbot.service.BodyConditionsService;
import com.smokedcorn.trainerbot.service.HobbyService;
import com.smokedcorn.trainerbot.service.RoutinesService;
import com.smokedcorn.trainerbot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

import static com.smokedcorn.trainerbot.util.MappingUtil.CONDITION_MAP;
import static com.smokedcorn.trainerbot.util.MappingUtil.HOBBY_MAP;

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
    public ResponseEntity<WorkoutDetail> getWorkouts(@RequestBody Routines routines) { //Routines routines
        // 플라스크 서버로 요청할 URL
        String flaskUrl = "https://c273-34-48-51-152.ngrok-free.app/getRoutine"; // 플라스크 서버의 URL

        // RestTemplate을 사용하여 플라스크 서버에 요청 보내기
        RestTemplate restTemplate = new RestTemplate();


//        System.out.println("getWorkouts called");
        User user = userService.getUserById(routines.getUserId());
        List<UserHobby> userHobbies = hobbyService.getAllHobbies(routines.getUserId());
        List<UserBodyConditions> userBodyConditions = bodyConditionsService.getBodyConditionById(routines.getUserId());

        System.out.println("user!!!!!!!!!" + user);
        System.out.println("userHobbies "+userHobbies);
        System.out.println("userbodyConditions" + userBodyConditions);

        String hobbies = "";
        String conditions = "";

        for (UserHobby userHobby: userHobbies) {
            hobbies +=  (HOBBY_MAP.get(userHobby.getHobby()) + " ");
        }

        for (UserBodyConditions condition: userBodyConditions) {
            conditions += (CONDITION_MAP.get(condition.getbCondId()+ " "));
        }

//        List<WorkoutDetail> workoutDetails = new ArrayList<>();


        // 요청할 데이터 (user 정보를 담은 객체)
        // 나이, 성별, 운동경험, 목표, 타겟, 오늘 몸상태, 취미 운동, 아픈 부위
        Map<String, String> userInfo = new HashMap<>();
        userInfo.put("age", String.valueOf(user.getBirthYear()));
        userInfo.put("gender", user.getGender());
        userInfo.put("workoutExperience", user.getWorkoutExperience());
        userInfo.put("goal", user.getGoal());
        userInfo.put("target", routines.getTarget());
        userInfo.put("todayCondition", routines.getCondition());
        userInfo.put("hobby", hobbies);
        userInfo.put("bodyCondition", conditions);

        // 플라스크 서버에 POST 요청을 보내기 위한 HttpEntity 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(userInfo, headers);

        // 플라스크 서버에 POST 요청 보내기
        ResponseEntity<Map> response = restTemplate.exchange(flaskUrl, HttpMethod.POST, requestEntity, Map.class);

        // 플라스크 서버에서 받은 응답 처리
        if (response.getStatusCode() == HttpStatus.OK) {
            // JSON 문자열로 응답 받음
            Map responseBody = response.getBody();

            // JSON 파싱 후 필요한 필드를 추출 (응답이 JSON 형식이라면 파싱 후 적절한 객체로 변환)
            // 예: JSON을 WorkoutDetail로 변환할 수 있도록 처리

            // 만약 JSON으로 WorkoutDetail 리스트로 변환하려면, 아래와 같이 ObjectMapper 등을 사용해서 변환할 수 있습니다:
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                // Assuming the response is in a valid JSON format for your object structure
                WorkoutDetail workoutDetail = objectMapper.readValue(
                        objectMapper.writeValueAsString(responseBody),
                        WorkoutDetail.class  // Directly deserializing into a single WorkoutDetail object
                );

                return ResponseEntity.ok(workoutDetail);  // Returning single WorkoutDetail object
            } catch (IOException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }

        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }






    }
}
