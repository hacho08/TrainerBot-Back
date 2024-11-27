package com.smokedcorn.trainerbot.controller.dto;

import java.util.List;

public class UserDetailsRequest {
    private List<Integer> conditionIndices; // 컨디션 인덱스 리스트
    private List<Integer> hobbyIndices;     // 취미 인덱스 리스트
    private List<Integer> goalIndices;      // 운동 목표 인덱스 리스트

    // Getter/Setter
    public List<Integer> getConditionIndices() {
        return conditionIndices;
    }

    public void setConditionIndices(List<Integer> conditionIndices) {
        this.conditionIndices = conditionIndices;
    }

    public List<Integer> getHobbyIndices() {
        return hobbyIndices;
    }

    public void setHobbyIndices(List<Integer> hobbyIndices) {
        this.hobbyIndices = hobbyIndices;
    }

    public List<Integer> getGoalIndices() {
        return goalIndices;
    }

    public void setGoalIndices(List<Integer> goalIndices) {
        this.goalIndices = goalIndices;
    }
}
