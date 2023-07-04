package org.example;

import org.example.repository7.Child1;
import org.example.repository7.GrandChild1;
import org.example.repository7.Parent1;
import org.example.repository8.Child2;
import org.example.repository8.GrandChild2;
import org.example.repository8.Parent2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main4 {
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

        Parent1 parent1 = new Parent1();
        parent1.setId("P_1");
        parent1.setName("parent1");

        em.persist(parent1);

        Child1 child1 = new Child1();
        child1.setChildId("C_1");
        child1.setParent1(parent1);
        child1.setName("child1");

        em.persist(child1);

        GrandChild1 grandChild1 = new GrandChild1();
        grandChild1.setId("GC_1");
        grandChild1.setChild1(child1);
        grandChild1.setName("GrandChild1");

        em.persist(grandChild1);

        tx.commit();
    }

    private static void logic1_2(EntityTransaction tx, EntityManager em) {
        tx.begin();

        Parent2 parent2 = new Parent2();
        parent2.setName("parent2");

        em.persist(parent2);

        Child2 child2 = new Child2();
        child2.setName("child2");
        child2.setParent(parent2);

        em.persist(child2);

        GrandChild2 grandChild2 = new GrandChild2();
        grandChild2.setName("grandChild2");
        grandChild2.setChild(child2);

        em.persist(grandChild2);

        tx.commit();
    }
}
