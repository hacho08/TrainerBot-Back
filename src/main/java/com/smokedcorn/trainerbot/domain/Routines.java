package com.smokedcorn.trainerbot.domain;

import jakarta.persistence.*;
import java.util.List;  // List 인터페이스 임포트
import java.util.Date;
import java.time.LocalDateTime;


@Entity
public class Routines {

    @Id
    private String routineId;

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", nullable = false)
    private User user;  // USER_ID와 연결

    private String condition;
    private String target;

    private Date createdAt;

    // 기본 생성자
    public Routines() {}

    // 전체 필드를 받는 생성자
    public Routines(String routineId, User user, String condition, String target, Date createdAt) {
        this.routineId = routineId;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    // toString(), equals(), hashCode() 등의 메서드도 필요에 따라 추가할 수 있습니다.
}
