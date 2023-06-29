package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        // 엔티티 메니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaconfig");
        // 엔티티 메니저 생성
        EntityManager em = emf.createEntityManager();
        // 트랜잭션 생성
        EntityTransaction tx = em.getTransaction();

        try {
            // 트랜잭션 시작
            tx.begin();
            // 비영속/영속 상태
//            logic1(em);
//            logic2(em);
//            logic3(em);
//            logic4(em);
            logic5(em);
            // 트랜잭션 커밋
            tx.commit();
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

    private static void logic1(EntityManager em) {
        String id="id1";

        ColumnTable3 c1 = new ColumnTable3();
        c1.setId(id);
        c1.setColumn1("data1");
        c1.setColumn2("data2");

        em.persist(c1);

        ColumnTable3 find3 = em.find(ColumnTable3.class, id);

        find3.setColumn1("data3");
        find3.setColumn2("data4");
    }

    private static void logic2(EntityManager em) {
        ColumnTable6 c1 = new ColumnTable6();
        c1.setColumn1("aaa");

        em.persist(c1);

        System.out.println(c1);
    }

    private static void logic3(EntityManager em) {
        ColumnTable7 c1 = new ColumnTable7();
        c1.setColumn1("aaa1");

        em.persist(c1);

        System.out.println(c1);
    }

    private static void logic4(EntityManager em) {
        ColumnTable8 c1 = new ColumnTable8();
        c1.setColumn1("aaa1");

        em.persist(c1);

        System.out.println(c1);
    }

    private static void logic5(EntityManager em) {
        ColumnTable9 c1 = new ColumnTable9();
        c1.setColumn1("aaa1");

        em.persist(c1);

        System.out.println(c1);
    }

}