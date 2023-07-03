package org.example.repository5;

import java.io.Serializable;
import java.util.Objects;

// 복합키 스펙을 지정하는 클래스
// serializable 인터페이스를 상속받아야 함
public class AccountId1 implements Serializable {
    // 복합키로 사용할 필드가 반드시 존재
    private String accountNumber;
    private String accountType;

    public AccountId1() {
    }

    public AccountId1(String accountNumber, String accountType) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
    }

    // 비교를 위한 메소드 오버라이드
    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if(obj==null || getClass() != obj.getClass() ) return false;
        AccountId1 that = (AccountId1) obj;
        return Objects.equals(accountNumber, that.accountNumber) && Objects.equals(accountType, that.accountType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, accountType);
    }

    @Override
    public String toString() {
        return "AccountId1{" +
                "accountNumber='" + accountNumber + '\'' +
                ", accountType='" + accountType + '\'' +
                '}';
    }
}
