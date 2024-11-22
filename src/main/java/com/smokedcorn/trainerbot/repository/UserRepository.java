package com.smokedcorn.trainerbot.repository;

import com.smokedcorn.trainerbot.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
