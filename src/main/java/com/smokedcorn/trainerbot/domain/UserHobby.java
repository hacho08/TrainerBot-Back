package com.smokedcorn.trainerbot.domain;
import jakarta.persistence.*;

@Entity
@Table(name="USER_HOBBY")
public class UserHobby {

    @Id
    @Column(name = "HOBBY_ID", nullable = false)
    private String hobbyId;

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", nullable = false)
    private User user;  // User 엔티티와 다대일 관계

    // 기본 생성자
    public UserHobby() {}

    // 전체 필드를 받는 생성자
    public UserHobby(String hobbyId, User user) {
        this.hobbyId = hobbyId;
        this.user = user;
    }

    // Getter and Setter methods
    public String getHobbyId() {
        return hobbyId;
    }

    public void setHobbyId(String hobbyId) {
        this.hobbyId = hobbyId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // toString(), equals(), hashCode() 등 필요한 메서드를 추가할 수 있습니다.
}

