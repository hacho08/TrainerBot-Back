package com.smokedcorn.trainerbot.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="BODY_CONDITIONS")
public class BodyConditions {

    @Id
    @Column(name = "B_COND_ID", nullable = false, length = 20)
    private String bCondId;

    @Column(name = "B_COND_NAME", nullable = false, length = 5)
    private String bCondName;

    @Column(name = "B_COND_DESCRIPTION", nullable = true, length = 100)
    private String bCondDescription;

    // 기본 생성자
    public BodyConditions() {}

    // 전체 필드를 받는 생성자
    public BodyConditions(String bCondId, String bCondName, String bCondDescription) {
        this.bCondId = bCondId;
        this.bCondName = bCondName;
        this.bCondDescription = bCondDescription;
    }


//    @OneToMany(mappedBy = "bodyConditions") // UserBodyCondition에서 bCondId 필드와 매핑
//    private List<UserBodyConditions> users;


    // Getter and Setter methods
    public String getbCondId() {
        return bCondId;
    }

    public void setbCondId(String bCondId) {
        this.bCondId = bCondId;
    }

    public String getbCondName() {
        return bCondName;
    }

    public void setbCondName(String bCondName) {
        this.bCondName = bCondName;
    }

    public String getbCondDescription() {
        return bCondDescription;
    }

    public void setbCondDescription(String bCondDescription) {
        this.bCondDescription = bCondDescription;
    }

    // toString(), equals(), hashCode() 등의 메서드도 필요에 따라 추가할 수 있습니다.
}
