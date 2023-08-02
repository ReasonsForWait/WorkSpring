package com.example.paymentTest.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Product {
    // 상품 고유 아이디
    @Id
    @GeneratedValue
    private Long pdid;

    // 상호명

    // 숙소 유형

    // 숙소 주소

    // 숙소 전화번호

    // 숙소 지역유형

    // 숙소 평점

    // 숙소 가격
    @Column
    private int pdprice;

    // 숙소 주말가격
}
