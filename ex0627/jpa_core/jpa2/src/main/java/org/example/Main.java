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

            // logic1(em);
            // logic2(em);
            logic3(em);
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



    // 비영속, 영속, 준영속, 삭제 상태 예제
    private static void logic1(EntityManager em) {
        // 비영속 상태
        // 영속 컨텍스트가 엔티티를 담고있지 않는 별도의 객체 상태
        String id = "member1";
        Member member = new Member();
        member.setId(id);
        member.setUsername("건주");
        member.setAge(30);

        // 영속 상태
        em.persist(member);

        // 준영속 상태 : 영속성 컨텍스트에 들어있는 엔티티를 컨텍스트와 분리
        em.detach(member);

        // 삭제
        em.remove(member);
    }
    private static void logic2(EntityManager em) {
        // 비영속 상태
//        Member member = new Member();
//        member.setId("member1");
//        member.setUsername("건주");
//        member.setAge(30);

        // 영속 상태
//        em.persist(member);금천고등학교

        // 1차 캐시에서 조회
        Member findMember1 = em.find(Member.class, "member1");
        System.out.println("findMember1.username : " + findMember1.getUsername());

        // DB에서 조회
        Member findMember2 = em.find(Member.class, "member2");
        System.out.println("findMember1.username : " + findMember2.getUsername());

        // 1차 캐시에서 조회
        Member findMember3 = em.find(Member.class, "member2");
        System.out.println("findMember1.username : " + findMember3.getUsername());
    }
    private static void logic3(EntityManager em) {
        Member memberA = new Member();
        memberA.setId("memberA");
        memberA.setUsername("건주");
        memberA.setAge(30);

        Member memberB = new Member();
        memberB.setId("memberB");
        memberB.setUsername("남주");
        memberB.setAge(28);

        // 영속상태
        em.persist(memberA);
        em.persist(memberB);

        // 업데이트
        memberA.setUsername("현승");
    }
}
