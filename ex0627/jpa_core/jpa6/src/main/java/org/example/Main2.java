package org.example;

import org.example.repository1.Album1;
import org.example.repository1.Book1;
import org.example.repository1.Movie1;
import org.example.repository4.Member1;
import org.example.repository4.Seller1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

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
        member1.setName("멤버1");
        member1.setEmail("aaa@bbb.com");
        member1.setCreateDate(LocalDateTime.now());

        Seller1 seller1 = new Seller1();
        seller1.setName("셀러1");
        seller1.setShopName("가게1");
        seller1.setCreateDate(LocalDateTime.now());

        em.persist(member1);
        em.persist(seller1);

        tx.commit();
    }
}
