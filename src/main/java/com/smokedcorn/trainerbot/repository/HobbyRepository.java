package com.smokedcorn.trainerbot.repository;

import com.smokedcorn.trainerbot.domain.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HobbyRepository extends JpaRepository<Hobby, String> {
    // 추가적인 쿼리 메서드를 정의할 수 있습니다.
}
