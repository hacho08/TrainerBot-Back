package com.smokedcorn.trainerbot.repository;

import com.smokedcorn.trainerbot.domain.Routines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoutinesRepository extends JpaRepository<Routines, String> {
    // 기본적인 CRUD 메서드는 JpaRepository가 자동으로 제공합니다.

//    List<Routines> findByUserUserId(String userId);
//
//    // 예: 루틴 ID로 루틴을 찾기 위한 메서드
//    Optional<Routines> findByRoutineId(String routineId);
}

