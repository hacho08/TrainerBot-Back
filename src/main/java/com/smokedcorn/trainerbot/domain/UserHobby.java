package com.smokedcorn.trainerbot.domain;
import jakarta.persistence.*;

@Entity
@Table(name="USER_HOBBY")
public class UserHobby {

    @Id
//    @ManyToOne
    @Column(name = "HOBBY_ID", nullable = false)
    private String hobby;  // Hobby 엔티티와 연결

//    @Id
    @Column(name = "USER_ID", nullable = false)
    private String userId;  // User 엔티티와 다대일 관계

    // 기본 생성자
    public UserHobby() {}

    // 전체 필드를 받는 생성자
    public UserHobby(String hobby, String userId) {
        this.hobby = hobby;
        this.userId = userId;
    }

    // Getter and Setter methods
    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    // toString(), equals(), hashCode() 등 필요한 메서드를 추가할 수 있습니다.
}

