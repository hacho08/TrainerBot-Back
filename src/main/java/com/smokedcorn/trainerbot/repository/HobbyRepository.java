package com.smokedcorn.trainerbot.repository;

import com.smokedcorn.trainerbot.domain.UserHobby;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HobbyRepository extends JpaRepository<UserHobby, String> {
    // 추가적인 쿼리 메서드를 정의할 수 있습니다.

    @Modifying
    @Transactional
    @Query("INSERT INTO UserHobby (userId, hobby) VALUES (:userId, :hobby)")
    void saveHobby(@Param("userId") String userId, @Param("hobby") String hobby);

    @Query(value = "SELECT * FROM USER_HOBBY WHERE USER_ID LIKE :userId", nativeQuery = true)
    List<UserHobby> getUserHobbyByUserId(@Param("userId") String userId);
}
