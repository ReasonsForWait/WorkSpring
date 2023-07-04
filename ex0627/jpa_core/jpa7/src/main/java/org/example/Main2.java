package org.example;

import org.example.repository2.Member2;
import org.example.repository2.Team2;

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
            logic1_2(tx, em);
            logic1_3(tx, em);
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

        Team2 team1 = new Team2();
        team1.setName("team1");

        em.persist(team1);

        Member2 member1 = new Member2();
        member1.setUsername("member1");
        member1.setTeam2(team1);

        em.persist(member1);

        Member2 member2 = new Member2();
        member2.setUsername("member2");
        member2.setTeam2(team1);

        em.persist(member2);

        tx.commit();
    }

    private static void logic1_2(EntityTransaction tx, EntityManager em) {
        tx.begin();

        em.clear();

        Member2 member1 = em.find(Member2.class, 1L);
        System.out.println("----------member1 find------------");

        tx.commit();
    }

    private static void logic1_3(EntityTransaction tx, EntityManager em) {
        tx.begin();

        em.clear();

        Team2 team1 = em.find(Team2.class, 1L);
        System.out.println("------member 리스트 호출 전------");

        for (Member2 m : team1.getMembers()) {
            System.out.println(m);
        }

        tx.commit();
    }
}
