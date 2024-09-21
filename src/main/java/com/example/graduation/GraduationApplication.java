package com.example.graduation;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.TimeZone;

@EnableJpaAuditing
@SpringBootApplication
//@EnableJpaRepositories
public class GraduationApplication {
//	@PostConstruct
//	void started() {
//		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
//	}
	public static void main(String[] args) {
		SpringApplication.run(GraduationApplication.class, args);
	}

}
