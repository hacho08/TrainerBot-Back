package com.smokedcorn.trainerbot.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name="ROUTINES")
public class Routines {

    @Id
    @Column(name = "ROUTINE_ID", nullable = false, length = 20)
    private String routineId;

    @Column(name = "USER_ID", nullable = false)
    private String userId;  // USER_ID와 연결

    @Column(name = "CONDITION", nullable = false, length = 20)
    private String condition;

    @Column(name = "TARGET", nullable = false, length = 10)
    private String target;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    // 기본 생성자
    public Routines() {}

    // 전체 필드를 받는 생성자
    public Routines(String routineId, String userId, String condition, String target, LocalDateTime createdAt) {
        this.routineId = routineId;
        this.userId = userId;
        this.condition = condition;
        this.target = target;
        this.createdAt = createdAt;
    }

    @OneToMany(mappedBy = "routine")  // WorkoutDetail에서 routine 필드와 매핑
    private List<WorkoutDetail> workoutDetails;


    // Getter and Setter methods
    public String getRoutineId() {
        return routineId;
    }

    public void setRoutineId(String routineId) {
        this.routineId = routineId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }


    // toString(), equals(), hashCode() 등의 메서드도 필요에 따라 추가할 수 있습니다.
}
