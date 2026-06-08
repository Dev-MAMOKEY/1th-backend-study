package com.project.boardDB.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// 설정 클래스
@Configuration

// JPA Auditing 기능 활성화
@EnableJpaAuditing
public class AuditingConfig {
}