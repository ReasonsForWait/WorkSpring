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

            // 비지니스 로직 실행
            logic(em);

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

    public static void logic(EntityManager em) {
        String id = "id1";
        Member member = new Member();
        member.setId(id);
        member.setUsername("건주");
        member.setAge(30);

        // 등록
        em.persist(member);

        // 수정
        member.setAge(40);
    }
}