package org.example.repository4;

import javax.persistence.*;

@Entity
@Table
public class MemberProduct4 {

    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member4 member;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product4 product;

    private Integer orderAmount;

    public MemberProduct4() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member4 getMember() {
        return member;
    }

    public void setMember(Member4 member) {
        this.member = member;
    }

    public Product4 getProduct() {
        return product;
    }

    public void setProduct(Product4 product) {
        this.product = product;
    }

    public Integer getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Integer orderAmount) {
        this.orderAmount = orderAmount;
    }

    @Override
    public String toString() {
        return "MemberProduct4{" +
                "orderAmount=" + orderAmount +
                '}';
    }
}
