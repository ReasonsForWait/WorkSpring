package org.example;

import org.example.repository1.Member1;

import javax.persistence.*;
import java.util.List;

public class Main {
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

        Member1 member1 = new Member1();
        member1.setUsername("member1");
        member1.setAge(10);
        em.persist(member1);

        Member1 member2 = new Member1();
        member2.setUsername("member2");
        member2.setAge(20);
        em.persist(member2);

        tx.commit();
    }

    private static void logic1_2(EntityTransaction tx, EntityManager em) {
        tx.begin();

        // typedquery를 활용한 select 기본 예제
        TypedQuery<Member1> query1 = em.createQuery("select m from Member1 m", Member1.class);
        List<Member1> list1 = query1.getResultList();

        System.out.println("----------------getResultList 예제1---------------");
        for(Member1 m1 : list1){
            System.out.println("name : "+m1.getUsername()+"   age : "+m1.getAge());
        }

        // 단일 컬럼을 활용한 기본 예제
        TypedQuery<String> query2 = em.createQuery("select m.username from Member1 m", String.class);
        List<String> list2 = query2.getResultList();

        System.out.println("----------------getResultList 예제2 (단일 컬럼 예제 > String)---------------");
        for(String str1 : list2){
            System.out.println("name : "+str1);
        }

        tx.commit();
    }
}



