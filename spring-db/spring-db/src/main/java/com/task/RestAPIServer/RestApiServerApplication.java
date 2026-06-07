package com.task.RestAPIServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// JPA Auditing 기능 활성화
// GlobalEntity의 @CreatedDate, @LastModifiedDate를 사용하기 위함
@EnableJpaAuditing

// 이 클래스가 Spring Boot Application의 시작점임을 나타냄
@SpringBootApplication
public class RestApiServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiServerApplication.class, args);
	}

}
