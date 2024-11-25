package com.smokedcorn.trainerbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.smokedcorn.trainerbot.domain")  // 엔티티 패키지 지정
@EnableJpaRepositories(basePackages = "com.smokedcorn.trainerbot.repository")  // 레포지토리 패키지 지정
public class TrainerbotApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainerbotApplication.class, args);
	}
}
