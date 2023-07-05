package org.example;

import org.example.repository1.Address1;
import org.example.repository1.Member1;
import org.example.repository1.Period1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class Main1 {
    public static void main(String[] args) {
        // 엔티티 메니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaconfig");
        // 엔티티 메니저 생성
        EntityManager em = emf.createEntityManager();
        // 트랜잭션 생성
        EntityTransaction tx = em.getTransaction();

        try {
//            logic1_1(tx, em);
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

        Member1 member1 = new Member1();
        member1.setName("회원1");

        Address1 address1 = new Address1();
        address1.setCity("수원");
        address1.setStreet("광교로");
        address1.setZipcode("12345");
        member1.setAddress(address1);

        Period1 period1 = new Period1();
        period1.setStartDate(LocalDateTime.now());
        period1.setEndDate(LocalDateTime.now());
        member1.setPeriod(period1);

        em.persist(member1);

        tx.commit();
    }
}