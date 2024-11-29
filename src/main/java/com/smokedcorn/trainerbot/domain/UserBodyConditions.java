package com.smokedcorn.trainerbot.domain;

import jakarta.persistence.*;

@Entity
@Table(name="USER_BODY_CONDITIONS")
public class UserBodyConditions {

    @Id
    @Column(name = "B_COND_ID")
    private String bCondId;

    @Column(name = "USER_ID")
    private String userId;


    // 기본 생성자
    public UserBodyConditions() {}

    // 전체 필드를 받는 생성자
    public UserBodyConditions(String bCondId, String userId) {
        this.bCondId = bCondId;
        this.userId = userId;
    }

    // Getter and Setter methods
    public String getbCondId() {
        return bCondId;
    }

    public void setbCondId(String bCondId) {
        this.bCondId = bCondId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    // toString(), equals(), hashCode() 등의 메서드도 필요에 따라 추가할 수 있습니다.
}
