package com.smokedcorn.trainerbot.domain;

import jakarta.persistence.*;

@Entity
@Table(name="USER_BODY_CONDITIONS")
public class UserBodyConditions {

    @Id
    private String bCondId;

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", nullable = false)
    private User user;

    // 기본 생성자
    public UserBodyConditions() {}

    // 전체 필드를 받는 생성자
    public UserBodyConditions(String bCondId, User user) {
        this.bCondId = bCondId;
        this.user = user;
    }

    // Getter and Setter methods
    public String getbCondId() {
        return bCondId;
    }

    public void setbCondId(String bCondId) {
        this.bCondId = bCondId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // toString(), equals(), hashCode() 등의 메서드도 필요에 따라 추가할 수 있습니다.
}
