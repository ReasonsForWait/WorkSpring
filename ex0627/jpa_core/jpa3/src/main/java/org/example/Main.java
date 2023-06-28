package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        // 엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaconfig");

        // 엔티티 매니저 생서
        EntityManager em = emf.createEntityManager();

        // 트랜잭션 생성
        EntityTransaction tx = em.getTransaction();

        try {
            // 트랜잭션 시작
            tx.begin();

            logic1(em);
            // 트랜잭션 커밋
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();

            // 트랜잭션 롤백
            tx.rollback();
        } finally {
            // 엔티티 매니저 종료
            em.close();
        }

        // 엔티티 매니저 팩토리 종료
        emf.close();
    }

    private static void logic1(EntityManager em) {
        ColumnTable3 ct3 = new ColumnTable3();
        ct3.setId("id1");
        ct3.setColumn1("data1");
        ct3.setColumn2("data2");

        em.persist(ct3);

        ColumnTable3 find3 = em.find(ColumnTable3.class, "id1");

        find3.setColumn1("data3");
        find3.setColumn2("data4");
    }
}