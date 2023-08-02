package com.example.paymentTest.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Payment {

    // 결제 아이디
    @Id
    @GeneratedValue
    private Long pmid;

    // 결제 된 시간
    @Column
    private LocalDateTime pmtime;

    // 결제 금액
    @Column
    private int pdprice;

    // 결제 상품 이름
    @Column
    private String pdname;

    // 결제한 멤버 FK

    // 상품 고유번호 FK
}
