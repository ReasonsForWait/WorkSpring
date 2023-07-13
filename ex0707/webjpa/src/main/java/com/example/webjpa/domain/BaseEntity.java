package com.example.webjpa.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class BaseEntity extends BaseTimeEntity{
    // 해당 엔티티가 생성될 때, 생성하는 시각을 처음으로 삽입해주는 어노테이션
//    @CreatedDate
    // 해당 컬럼을 수정 못하도록 막는다
//    @Column(updatable = false, nullable = false)
//    private LocalDateTime createDate;

    // 해당 엔티티가 수정될 때, 수정하는 시각을 자동으로 삽입해주는 어노테이션
//    @LastModifiedDate
//    @Column(nullable = false)
//    private LocalDateTime updateDate;

    // 해당 엔티티가 생성될 때, 생성하는 사람이 누군지 자동으로 삽입한다.
    // 생성하는 주체를 지정하기 위해서 AuditorAware<T>를 지정해야 한다.
    @CreatedBy
    @Column(updatable = false)
    private String createBy;

    // 해당 엔티티가 수정될 때, 수정하는 사람이 누군지 자동으로 삽입한다.
    // 생성하는 주체를 지정하기 위해서 AuditorAware<T>를 지정해야 한다.
    @LastModifiedBy
    private String updateBy;


}
