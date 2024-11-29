package com.smokedcorn.trainerbot.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity  // 해당 클래스는 JPA 엔티티임을 나타냅니다.
@Table(name="USERS")
public class User {

    @Id
    @Column(name = "USER_ID", nullable = false, length = 20)  // 컬럼 이름이 대소문자 구분이므로 주의하여 설정
    private String userId;

    @Column(name = "USER_NAME", nullable = false, length = 30)
    private String userName;

    @Column(name = "BIRTH_YEAR", nullable = false)
    private int birthYear;

    @Column(name = "GENDER", nullable = false, length = 10)
    private String gender;

    @Column(name = "WORKOUT_EXPERIENCE", nullable = false, length = 20)
    private String workoutExperience;

    @Column(name = "GOAL", nullable = false, length = 50)
    private String goal;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    // Transient fields for joined data
    @Transient
    @JsonProperty("B_COND_NAME")
//    @Column(name = "B_COND_NAME", nullable = false, length = 50) // Transient에 @Column은 무의미하지만 명시적으로 적을 수도 있음
    private List<Integer> bodyConditionIds;

    @Transient
    @JsonProperty("HOBBY_NAME")
//    @Column(name = "HOBBY_NAME", nullable = false, length = 70)
    private List<Integer> hobby;


    // 기본 생성자
    public User() {
    }

    // 전체 필드를 받는 생성자
    public User(String userId, String userName, int birthYear, String gender, String workoutExperience, String goal, LocalDateTime createdAt) {
        this.userId = userId;
        this.userName = userName;
        this.birthYear = birthYear;
        this.gender = gender;
        this.workoutExperience = workoutExperience;
        this.goal = goal;
        this.createdAt = createdAt;
    }

//    @OneToMany(mappedBy = "user") // UserHobby에서 user 필드와 매핑
//    private List<UserHobby> hobbies;
//
//    @OneToMany(mappedBy = "user") // UserBodyCondition에서 user 필드와 매핑
//    private List<UserBodyConditions> bodyConditions;
//
//    @OneToMany(mappedBy = "user")  // User와 Routine 사이의 관계를 매핑
//    private List<Routines> routines;
//
    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, orphanRemoval = true)  // User와 Booking 사이의 관계를 매핑
    private List<Booking> bookings;

//    public User(String userId) {
//    }


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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<Integer> getBCondName() {
        return bodyConditionIds;
    }

    public void setBCondName(List<Integer> bCondName) {
        // null 체크 후 빈 리스트로 초기화
        if (bCondName == null) {
            this.bodyConditionIds = new ArrayList<>();
        } else {
            this.bodyConditionIds = bCondName;
        }
    }

    public List<Integer> getHobbyName() {
        return hobby;
    }

    public void setHobbyName(List<Integer> hobbyName) {
        this.hobby = hobbyName;
    }
}
