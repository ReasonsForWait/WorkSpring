package org.example.repository6;

import org.example.repository5.AccountId1;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AccountId2 implements Serializable {

    private String accountNumber;
    private String accountType;

    public AccountId2() {
    }

    public AccountId2(String accountNumber, String accountType) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if(obj==null || getClass() != obj.getClass() ) return false;
        AccountId2 that = (AccountId2) obj;
        return Objects.equals(accountNumber, that.accountNumber) && Objects.equals(accountType, that.accountType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, accountType);
    }

    @Override
    public String toString() {
        return "AccountId2{" +
                "accountNumber='" + accountNumber + '\'' +
                ", accountType='" + accountType + '\'' +
                '}';
    }
}
