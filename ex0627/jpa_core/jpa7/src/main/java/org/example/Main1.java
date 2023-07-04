package org.example;

import org.example.repository1.Member1;

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

        Member1 member1 = new Member1();
        member1.setName("member1");
        em.persist(member1);

        Member1 member2 = new Member1();
        member2.setName("member2");
        em.persist(member2);

        tx.commit();
    }

    private static void logic1_2(EntityTransaction tx, EntityManager em) {
        tx.begin();

        // 모든 영속성 컨텍스트의 초기화
        em.clear();

        // Persistence Context 에 Entity가 없으면 데이터베이스를 조회
        // 엔티티를 사용하지 않아도 데이터베이스를 조회함
        Member1 member1 = em.find(Member1.class, 1L);

        System.out.println("member1.getId : "+member1.getId());
        System.out.println("member1.getName : "+member1.getName());

        // 엔티티를 직접 사용하는 시점까지 데이터베이스의 조회를 미룸
        Member1 member2 = em.find(Member1.class, 2L);

        // 엔티티에 이미 존재하는 값이 있을 경우 select 문을 쓸 필요 없이 기존 값을 그대로 리턴하고
        // 만약 해당 값이 엔티티에 존재하지 않을 경우 DB에서 데이터를 색인하여 가져온다.
        System.out.println("member2.getId : "+member2.getId());
        System.out.println("member2.getName : "+member2.getName());

        tx.commit();
    }

    private static void logic1_3(EntityTransaction tx, EntityManager em) {
        tx.begin();

        em.clear();

        Member1 member1 = em.getReference(Member1.class, 1L);
        Member1 member2 = em.find(Member1.class, 1L);

        System.out.println("-------일반 객체와 프록시 객체의 비교---------");
        System.out.println("member1.getClass() : "+member1.getClass());
        System.out.println("member2.getClass() : "+member2.getClass());
        System.out.println((member1 == member2));

        tx.commit();
    }

    private static void logic1_4(EntityTransaction tx, EntityManager em) {
        tx.begin();

        em.clear();

        System.out.println("---영속성을 제거한 후 값을 불러올 시---");

        Member1 member1 = em.getReference(Member1.class, 1L);
        System.out.println("member1.getClass() : " +member1.getClass());

        em.detach(member1);

        System.out.println(member1.getName());

        tx.commit();
    }
}