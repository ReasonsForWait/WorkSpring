package org.example;

import org.example.repository1.Member1;
import org.example.repository1.Team1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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

        Member1 member1 = new Member1("member1");
        Member1 member2 = new Member1("member2");

        Team1 team1 = new Team1("team1");
        team1.getMembers().add(member1);
        team1.getMembers().add(member2);

        em.persist(member1);
        em.persist(member2);
        em.persist(team1);

        tx.commit();
    }

    private static void logic1_2(EntityTransaction tx, EntityManager em) {
        tx.begin();

        Member1 member1 = new Member1("member1");
        Member1 member2 = new Member1("member2");

        Team1 team1 = new Team1("team1");
        team1.getMembers().add(member1);
        team1.getMembers().add(member2);

        member1.setTeam1(team1);
        member2.setTeam1(team1);

        em.persist(member1);
        em.persist(member2);
        em.persist(team1);

        tx.commit();
    }
}