package com.project.boardDB.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter

// 공통 필드를 여러 엔티티에서 상속받아 사용할 수 있도록 설정
// BaseEntity 자체는 테이블로 생성되지 않음
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class) // 이 엔티티의 저장, 수정을 누가 언제 어떻게 한건지 알수있는 리스너를 등록
public class BaseEntity {

    // 생성 시간
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    // 수정 시간
    @LastModifiedDate
    private LocalDateTime modifiedAt;
}