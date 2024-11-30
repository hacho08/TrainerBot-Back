package com.smokedcorn.trainerbot.service;

import com.smokedcorn.trainerbot.domain.UserBodyConditions;
import com.smokedcorn.trainerbot.repository.BodyConditionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BodyConditionsService {

    private final BodyConditionsRepository bodyConditionsRepository;

    @Autowired
    public BodyConditionsService(BodyConditionsRepository bodyConditionRepository) {
        this.bodyConditionsRepository = bodyConditionRepository;
    }


    // 특정 신체 상태 조회
    public Optional<UserBodyConditions> getBodyConditionById(String userId) {
        return bodyConditionsRepository.findById(userId);
    }
//
//    // 신체 상태 추가
//    public BodyConditions createBodyCondition(BodyConditions bodyCondition) {
//        return bodyConditionsRepository.save(bodyCondition);
//    }

}

