package com.smokedcorn.trainerbot.repository;

import com.smokedcorn.trainerbot.domain.BodyConditions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BodyConditionsRepository extends JpaRepository<BodyConditions, String> {
    // 기본적인 CRUD 작업은 JpaRepository가 자동으로 제공합니다.
    // 예: findAll(), findById(), save(), delete() 등

    // 추가적인 쿼리 메서드를 정의할 수 있습니다.
    // 예: 특정 조건명으로 BodyCondition 찾기
//    BodyConditions findByBCondName(String bCondName);
}
