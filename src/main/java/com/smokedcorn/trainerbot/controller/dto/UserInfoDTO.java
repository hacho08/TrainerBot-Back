package com.smokedcorn.trainerbot.controller.dto;

import java.time.LocalDateTime;
import java.util.List;

public class UserInfoDTO {
    private String userId;
    private String userName;
    private int birthYear;
    private String gender;
    private String workoutExperience;
    private String goal;
    private LocalDateTime createdAt;
    private List<Integer> bodyConditionIds; // 컨디션 인덱스 리스트
    private List<Integer> hobby;     // 취미 인덱스 리스트
         // 운동 목표 인덱스 리스트


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getWorkoutExperience() {
        return workoutExperience;
    }

    public void setWorkoutExperience(String workoutExperience) {
        this.workoutExperience = workoutExperience;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public List<Integer> getBodyConditionIds() {
        return bodyConditionIds;
    }

    public void setBodyConditionIds(List<Integer> bodyConditionIds) {
        this.bodyConditionIds = bodyConditionIds;
    }

    public List<Integer> getHobby() {
        return hobby;
    }

    public void setHobby(List<Integer> hobby) {
        this.hobby = hobby;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
