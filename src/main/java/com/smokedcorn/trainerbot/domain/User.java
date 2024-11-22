package com.smokedcorn.trainerbot.domain;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;  // List 인터페이스 임포트

import java.time.LocalDateTime;

@Entity  // 해당 클래스는 JPA 엔티티임을 나타냅니다.
@Table(name="USERS")
public class User {

    @Id
    @Column(name = "USER_ID")  // 컬럼 이름이 대소문자 구분이므로 주의하여 설정
    private String userId;

    @Column(name = "BIRTH_YEAR", nullable = false)
    private int birthYear;

    @Column(nullable = false)
    private String gender;

    @Column(name = "WORKOUT_EXPERIENCE", nullable = false)
    private String workoutExperience;

    @Column(nullable = false)
    private String goal;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    // 기본 생성자
    public User() {
    }

    // 전체 필드를 받는 생성자
    public User(String userId, int birthYear, String gender, String workoutExperience, String goal, LocalDateTime createdAt) {
        this.userId = userId;
        this.birthYear = birthYear;
        this.gender = gender;
        this.workoutExperience = workoutExperience;
        this.goal = goal;
        this.createdAt = createdAt;
    }

    @OneToMany(mappedBy = "user") // UserHobby에서 user 필드와 매핑
    private List<UserHobby> hobbies;

    @OneToMany(mappedBy = "user") // UserBodyCondition에서 user 필드와 매핑
    private List<UserBodyConditions> bodyConditions;

    @OneToMany(mappedBy = "user")  // User와 Routine 사이의 관계를 매핑
    private List<Routines> routines;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
}
