package org.example.repository6;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Account2 {
    @EmbeddedId
    private AccountId2 accountId2;
    private String accountName;

    public AccountId2 getAccountId2() {
        return accountId2;
    }

    public void setAccountId2(AccountId2 accountId2) {
        this.accountId2 = accountId2;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Override
    public String toString() {
        return "Account2{" +
                "accountId2=" + accountId2 +
                ", accountName='" + accountName + '\'' +
                '}';
    }
}
