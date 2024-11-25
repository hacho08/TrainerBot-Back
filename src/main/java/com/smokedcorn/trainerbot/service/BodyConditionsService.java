package com.smokedcorn.trainerbot.service;

import com.smokedcorn.trainerbot.domain.BodyConditions;
import com.smokedcorn.trainerbot.repository.BodyConditionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    // 신체 상태 조회
    public List<BodyConditions> getAllBodyConditions() {
        return bodyConditionsRepository.findAll();
    }

    // 특정 신체 상태 조회
    public Optional<BodyConditions> getBodyConditionById(String bodyConditionId) {
        return bodyConditionsRepository.findById(bodyConditionId);
    }

    // 신체 상태 추가
    public BodyConditions createBodyCondition(BodyConditions bodyCondition) {
        return bodyConditionsRepository.save(bodyCondition);
    }

    // 신체 상태 수정
    public BodyConditions updateBodyCondition(BodyConditions bodyCondition) {
        return bodyConditionsRepository.save(bodyCondition);
    }

    // 신체 상태 삭제
    public void deleteBodyCondition(String bodyConditionId) {
        bodyConditionsRepository.deleteById(bodyConditionId);
    }
}

