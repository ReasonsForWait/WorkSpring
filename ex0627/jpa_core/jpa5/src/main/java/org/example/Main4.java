package org.example;

import org.example.repository4.Member4;
import org.example.repository4.MemberProduct4;
import org.example.repository4.Product4;

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
            logic2_2(tx, em);
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

        Member4 member1 = new Member4("회원1");
        em.persist(member1);

        Product4 product1 = new Product4("상품1");
        em.persist(product1);

        MemberProduct4 memberProduct = new MemberProduct4();
        memberProduct.setMember(member1);
        memberProduct.setProduct(product1);
        memberProduct.setOrderAmount(3);
        em.persist(memberProduct);

        tx.commit();
    }

    private static void logic2_2(EntityTransaction tx, EntityManager em) {
        tx.begin();

        MemberProduct4 memberProduct4 = em.find(MemberProduct4.class, 3L);
        Member4 member = memberProduct4.getMember();
        Product4 product = memberProduct4.getProduct();

        System.out.println(member);
        System.out.println(product);
        System.out.println(memberProduct4);

        tx.commit();
    }
}
