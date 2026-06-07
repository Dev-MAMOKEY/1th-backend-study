package com.task.RestAPIServer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

// Lombok을 통해 이 클래스의 필드에 대한 getter를 자동 생성
@Getter

// 이 클래스가 독립적인 Entity가 아닌 다른 Entity들이 공통 필드를 상속받기 위한 부포 클래스임을 의미
@MappedSuperclass

// JPA Auditing 기능을 사용하기 위해 AuditingEntityListener를 등록
// Entity가 저장되거나 수정될 때, createdAt, updatedAt 값을 자동 처리
@EntityListeners(AuditingEntityListener.class)
public class GlobalEntity {

    // Entity가 처음 생성되어 저장될 때 현재 시간이 자등으로 들어감
    @CreatedDate

    // DB 컬럼 설정으로, null 값을 허용하지 않으며 한 번 저장된 후 수정되지 않음
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    // Entity가 수정될 때 마다 현재 시간이 자동으로 갱신
    @LastModifiedDate

    // DB 컬럼 설정으로, null 값을 허용하지 않음
    @Column(nullable = false)
    private LocalDateTime updatedAt;
}
