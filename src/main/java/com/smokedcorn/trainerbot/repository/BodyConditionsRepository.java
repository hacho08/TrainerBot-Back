package com.smokedcorn.trainerbot.repository;

import com.smokedcorn.trainerbot.domain.UserBodyConditions;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BodyConditionsRepository extends JpaRepository<UserBodyConditions, String> {
    // 기본적인 CRUD 작업은 JpaRepository가 자동으로 제공합니다.
    // 예: findAll(), findById(), save(), delete() 등

    @Modifying
    @Transactional
    @Query("INSERT INTO UserBodyConditions (userId, bCondId) VALUES (:userId, :bCondId)")
    void saveBCond(@Param("userId") String userId, @Param("bCondId") String bCondId);

    @Query(value = "SELECT * FROM USER_BODY_CONDITIONS WHERE USER_ID LIKE :userId", nativeQuery = true)
    List<UserBodyConditions> getBodyConditionByUserId(@Param("userId") String userId);

}
