package org.example;

import org.example.repository2.Locker2;
import org.example.repository2.Member2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main2 {
    public static void main(String[] args) {
        // 엔티티 메니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaconfig");
        // 엔티티 메니저 생성
        EntityManager em = emf.createEntityManager();
        // 트랜잭션 생성
        EntityTransaction tx = em.getTransaction();

        try {
            logic1_1(tx, em);
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

        Member2 member1 = new Member2("member1");
        Locker2 locker1 = new Locker2("locker1");

        member1.setLocker(locker1);

        em.persist(locker1);
        em.persist(member1);

        tx.commit();
    }
}
