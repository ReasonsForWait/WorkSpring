package org.example;

import org.example.repository5.Account1;
import org.example.repository5.AccountId1;
import org.example.repository6.Account2;
import org.example.repository6.AccountId2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main3 {
    public static void main(String[] args) {
        // 엔티티 메니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaconfig");
        // 엔티티 메니저 생성
        EntityManager em = emf.createEntityManager();
        // 트랜잭션 생성
        EntityTransaction tx = em.getTransaction();

        try {
            logic1_1(tx, em);
            logic1_2(tx, em);
            logic1_3(tx, em);
            logic1_4(tx, em);
            logic1_5(tx, em);
        } catch (Exception e){
            e.printStackTrace();
            // 트랜잭션 롤백
            tx.rollback();
        } finally {
            // 엔티티 메니저 종료
            em.close();
        }
        // 엔티티 메니저 팩토리 종료
        emf.close();
    }

    private static void logic1_1(EntityTransaction tx, EntityManager em) {
        tx.begin();

        Account1 account1 = new Account1();
        account1.setAccountNumber("1111");
        account1.setAccountType("A");
        account1.setAccountName("계정A");

        em.persist(account1);

        tx.commit();
    }

    private static void logic1_2(EntityTransaction tx, EntityManager em) {
        tx.begin();

        Account2 account2 = new Account2();
        account2.setAccountId2((new AccountId2("2222","B")));
        account2.setAccountName("계정2");

        em.persist(account2);

        tx.commit();
    }

    private static void logic1_3(EntityTransaction tx, EntityManager em) {
        tx.begin();

        AccountId1 accountId1 = new AccountId1("1111","A");
        Account1 account1 = em.find(Account1.class, accountId1);
        System.out.println(account1);

        tx.commit();
    }

    private static void logic1_4(EntityTransaction tx, EntityManager em) {
        tx.begin();

        AccountId2 accountId2 = new AccountId2("2222","B");
        Account2 account2 = em.find(Account2.class, accountId2);
        System.out.println(account2);

        tx.commit();
    }

    private static void logic1_5(EntityTransaction tx, EntityManager em) {
        tx.begin();

        AccountId1 accountId1 = new AccountId1("1111","A");
        AccountId1 accountId2 = new AccountId1("1111","A");

        System.out.println(accountId1.equals(accountId2));

        tx.commit();
    }
}
