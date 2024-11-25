package com.smokedcorn.trainerbot.domain;
import jakarta.persistence.*;

@Entity
@Table(name="USER_HOBBY")
public class UserHobby {

    @Id
//    @ManyToOne
    @JoinColumn(name = "HOBBY_ID", referencedColumnName = "HOBBY_ID", nullable = false)
    private String hobby;  // Hobby 엔티티와 연결

//    @Id
    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", nullable = false)
    private User user;  // User 엔티티와 다대일 관계

    // 기본 생성자
    public UserHobby() {}

    // 전체 필드를 받는 생성자
    public UserHobby(Hobby hobby, User user) {
        this.hobby = String.valueOf(hobby);
        this.user = user;
    }

    // Getter and Setter methods
    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // toString(), equals(), hashCode() 등 필요한 메서드를 추가할 수 있습니다.
}

