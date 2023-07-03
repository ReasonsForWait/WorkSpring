package org.example.repository4;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
// 이름만 바꿔 정의하는 어노테이션
// @AttributeOverride(name = "createDate", column = @Column(name = "signupDate"))
// 복수개로 컬럼의 이름을 바꿔 선언할 경우 사용하는 어노테이션
@AttributeOverrides({
        @AttributeOverride(name = "name", column = @Column(name = "username")),
        @AttributeOverride(name = "createDate", column = @Column(name = "signupDate"))
})
public class Member1 extends SubEntity1{
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
