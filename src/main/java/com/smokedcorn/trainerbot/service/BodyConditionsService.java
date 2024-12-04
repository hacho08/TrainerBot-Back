package com.smokedcorn.trainerbot.service;

import com.smokedcorn.trainerbot.domain.UserBodyConditions;
import com.smokedcorn.trainerbot.domain.UserHobby;
import com.smokedcorn.trainerbot.repository.BodyConditionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BodyConditionsService {

    private final BodyConditionsRepository bodyConditionsRepository;

    @Autowired
    public BodyConditionsService(BodyConditionsRepository bodyConditionRepository) {
        this.bodyConditionsRepository = bodyConditionRepository;
    }


    // 특정 신체 상태 조회
    public List<UserBodyConditions> getBodyConditionById(String userId) {
        return bodyConditionsRepository.getBodyConditionByUserId(userId);
    }
//
//    // 신체 상태 추가
//    public BodyConditions createBodyCondition(BodyConditions bodyCondition) {
//        return bodyConditionsRepository.save(bodyCondition);
//    }

}

