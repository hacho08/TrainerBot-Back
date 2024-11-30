package com.smokedcorn.trainerbot.repository;

import com.smokedcorn.trainerbot.domain.Routines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoutinesRepository extends JpaRepository<Routines, String> {
    // 기본적인 CRUD 메서드는 JpaRepository가 자동으로 제공합니다.
    @Query(value = "SELECT * FROM ( " +
            "   SELECT target " +
            "   FROM routines " +
            "   WHERE user_id LIKE :userId " +
            "   ORDER BY created_at DESC " +
            ") WHERE ROWNUM = 1", nativeQuery = true)
    String getTarget(@Param("userId") String userId);
}

