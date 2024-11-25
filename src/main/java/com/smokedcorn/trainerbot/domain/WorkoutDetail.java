package com.smokedcorn.trainerbot.domain;
import jakarta.persistence.*;

@Entity
@Table(name="WORKOUT_DETAIL")
public class WorkoutDetail {

    @Id
    private String workoutId;

    @ManyToOne
    @JoinColumn(name = "ROUTINE_ID", referencedColumnName = "ROUTINE_ID", nullable = false)
    private Routines routine;  // ROUTINE_ID와 연결

    private String workoutName;
    private Integer setCount;
    private Integer restTime;
    private Integer isCount;
    private Integer workoutCount;
    private Integer workoutOrder;

    // 기본 생성자
    public WorkoutDetail() {}

    // 전체 필드를 받는 생성자
    public WorkoutDetail(String workoutId, Routines routines, String workoutName, Integer setCount, Integer restTime, Integer isCount, Integer workoutCount, Integer workoutOrder) {
        this.workoutId = workoutId;
        this.routine = routines;
        this.workoutName = workoutName;
        this.setCount = setCount;
        this.restTime = restTime;
        this.isCount = isCount;
        this.workoutCount = workoutCount;
        this.workoutOrder = workoutOrder;
    }

    // Getter and Setter methods
    public String getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(String workoutId) {
        this.workoutId = workoutId;
    }

    public Routines getRoutine() {
        return routine;
    }

    public void setRoutine(Routines routine) {
        this.routine = routine;
    }

    public String getWorkoutName() {
        return workoutName;
    }

    public void setWorkoutName(String workoutName) {
        this.workoutName = workoutName;
    }

    public Integer getSetCount() {
        return setCount;
    }

    public void setSetCount(Integer setCount) {
        this.setCount = setCount;
    }

    public Integer getRestTime() {
        return restTime;
    }

    public void setRestTime(Integer restTime) {
        this.restTime = restTime;
    }

    public Integer getIsCount() {
        return isCount;
    }

    public void setIsCount(Integer isCount) {
        this.isCount = isCount;
    }

    public Integer getWorkoutCount() {
        return workoutCount;
    }

    public void setWorkoutCount(Integer workoutCount) {
        this.workoutCount = workoutCount;
    }

    public Integer getWorkoutOrder() {
        return workoutOrder;
    }

    public void setWorkoutOrder(Integer workoutOrder) {
        this.workoutOrder = workoutOrder;
    }

    // toString(), equals(), hashCode() 등의 메서드도 필요에 따라 추가할 수 있습니다.
}

