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
            // 비영속/영속 상태
            logic1_1(tx, em);
            logic1_2(tx, em);
            logic1_3(tx, em);
            logic1_4(tx, em);
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

        //팀1 저장
        Team1 team1 = new Team1("team1","팀1");
        em.persist(team1);

        // 회원1 저장
        Member1 member1 = new Member1("member1","회원1");
        member1.setTeam1(team1);
        em.persist(member1);

        // 회원2 저장
        Member1 member2 = new Member1("member2","회원2");
        member2.setTeam1(team1);
        em.persist(member2);

        tx.commit();
    }

    private static void logic1_2(EntityTransaction tx, EntityManager em) {
        tx.begin();

        Member1 member1 = em.find(Member1.class, "member1");
        // 다대일 관계에서 대쪽의 참조 객체를 get 메서드를 통해 가져와 참조할 수 있다.
        Team1 team1 = member1.getTeam1();

        System.out.println("tema1 : "+team1);

        tx.commit();
    }

    private static void logic1_3(EntityTransaction tx, EntityManager em) {
        tx.begin();

        Team1 team2 = new Team1("team2","팀2");
        em.persist(team2);

        Member1 member1 = em.find(Member1.class, "member1");
        // 회원1의 팀 소속을 팀2로 바꾸기
        member1.setTeam1(team2);

        tx.commit();
    }

    private static void logic1_4(EntityTransaction tx, EntityManager em) {
        tx.begin();

        // team2를 삭제 하기
        Member1 member1 = em.find(Member1.class, "member1");
        Team1 tema2 = member1.getTeam1();
        member1.setTeam1(null);

        em.remove(tema2);

        tx.commit();
    }
}