package com.smokedcorn.trainerbot.domain;
import jakarta.persistence.*;
import java.util.List;  // List 인터페이스 임포트

@Entity  // JPA 엔티티를 나타내는 어노테이션
@Table(name="HOBBY")
public class Hobby {

    @Id
    @Column(name = "HOBBY_ID", nullable = false, length = 20)
    private String hobbyId;

    @Column(name = "HOBBY_NAME", nullable = false, length = 70)
    private String hobbyName;

    // 기본 생성자
    public Hobby() {}

    // 전체 필드를 받는 생성자
    public Hobby(String hobbyId, String hobbyName) {
        this.hobbyId = hobbyId;
        this.hobbyName = hobbyName;
    }

    @OneToMany(mappedBy = "hobby") // UserHobby에서 hobby 필드와 매핑
    private List<UserHobby> users;


    // Getter and Setter methods
    public String getHobbyId() {
        return hobbyId;
    }

    public void setHobbyId(String hobbyId) {
        this.hobbyId = hobbyId;
    }

    public String getHobbyName() {
        return hobbyName;
    }

    public void setHobbyName(String hobbyName) {
        this.hobbyName = hobbyName;
    }

    // toString(), equals(), hashCode() 등의 메서드도 필요에 따라 추가할 수 있습니다.
}

