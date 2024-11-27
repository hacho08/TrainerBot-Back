package com.smokedcorn.trainerbot.service;

import com.smokedcorn.trainerbot.util.MappingUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataConversionService {

    /**
     * 컨디션 인덱스를 텍스트로 변환
     * @param conditionIndices 컨디션 인덱스 리스트
     * @return 컨디션 텍스트 리스트
     */
    public List<String> convertConditionIndicesToText(List<Integer> conditionIndices) {
        return conditionIndices.stream()
                .map(MappingUtil.CONDITION_MAP::get) // 인덱스를 텍스트로 변환
                .collect(Collectors.toList());
    }

    /**
     * 취미 인덱스를 텍스트로 변환
     * @param hobbyIndices 취미 인덱스 리스트
     * @return 취미 텍스트 리스트
     */
    public List<String> convertHobbyIndicesToText(List<Integer> hobbyIndices) {
        return hobbyIndices.stream()
                .map(MappingUtil.HOBBY_MAP::get) // 인덱스를 텍스트로 변환
                .collect(Collectors.toList());
    }

    /**
     * 운동 목표 인덱스를 텍스트로 변환
     * @param goalIndices 운동 목표 인덱스 리스트
     * @return 운동 목표 텍스트 리스트
     */
    public List<String> convertGoalIndicesToText(List<Integer> goalIndices) {
        return goalIndices.stream()
                .map(MappingUtil.GOAL_MAP::get) // 인덱스를 텍스트로 변환
                .collect(Collectors.toList());
    }
}
