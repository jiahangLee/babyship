package com.jiahanglee.babyship;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableJpaAuditing
//@EnableWebSecurity
@MapperScan("com.jiahanglee.babyship.dao")
public class BabyshipApplication {

	public static void main(String[] args) {
		SpringApplication.run(BabyshipApplication.class, args);
	}
}
