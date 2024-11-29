package com.smokedcorn.trainerbot.repository;

import com.smokedcorn.trainerbot.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

//    @Query("SELECT u, bc.bCondName, h.hobbyName " +
//            "FROM User u " +
//            "LEFT JOIN UserBodyConditions ubc ON u.userId = ubc.userId " +
//            "LEFT JOIN BodyConditions bc ON ubc.bCondId = bc.bCondId " +
//            "LEFT JOIN UserHobby uh ON u.userId = uh.userId " +
//            "LEFT JOIN Hobby h ON uh.hobbyId = h.hobbyId " +
//            "WHERE u.userId = :userId")
//    List<Object[]> findUserWithDetails(@Param("userId") String userId);

}
