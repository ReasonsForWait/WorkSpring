package org.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // DB 테이블에 대응되는 클래스를 지정할 때 쓰는 어노테이션
@Table(name = "member") // Entity와 매핑할 테이블
public class Member {

    public Member(){
    }
    public Member(String id, String username, Integer age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }

    @Id // JPA가 Entity를 관리할 때 식별할 기본키(PK)를 지정할 때 쓰는 어노테이션
    @Column(name="id") // 객체 필드를 테이블 컬럼에
    private String id;
    @Column(name="name")
    private String username;
    private Integer age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
