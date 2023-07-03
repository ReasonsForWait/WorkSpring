package org.example;

import org.example.repository1.Album1;
import org.example.repository1.Book1;
import org.example.repository1.Movie1;
import org.example.repository2.Album2;
import org.example.repository2.Book2;
import org.example.repository2.Movie2;
import org.example.repository3.Album3;
import org.example.repository3.Book3;
import org.example.repository3.Movie3;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

// 상속관계 매핑 정의
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

        Album1 album1 = new Album1();
        album1.setName("앨범1");
        album1.setPrice(5000);
        album1.setArtist("작곡가1");

        Movie1 movie1 = new Movie1();
        movie1.setName("영화1");
        movie1.setPrice(10000);
        movie1.setDirection("감독1");
        movie1.setActor("주연1");

        Book1 book1 = new Book1();
        book1.setName("도서1");
        book1.setPrice(7000);
        book1.setAuthor("작가1");
        book1.setIsbn("책번호12345");

        em.persist(album1);
        em.persist(movie1);
        em.persist(book1);

        tx.commit();
    }

    private static void logic1_2(EntityTransaction tx, EntityManager em) {
        tx.begin();

        Album2 album2 = new Album2();
        album2.setName("앨범1");
        album2.setPrice(5000);
        album2.setArtist("작곡가1");

        Movie2 movie2 = new Movie2();
        movie2.setName("영화1");
        movie2.setPrice(10000);
        movie2.setDirection("감독1");
        movie2.setActor("주연1");

        Book2 book2 = new Book2();
        book2.setName("도서1");
        book2.setPrice(7000);
        book2.setAuthor("작가1");
        book2.setIsbn("책번호12345");

        em.persist(album2);
        em.persist(movie2);
        em.persist(book2);

        tx.commit();
    }

    private static void logic1_3(EntityTransaction tx, EntityManager em) {
        tx.begin();

        Album3 album3 = new Album3();
        album3.setName("앨범1");
        album3.setPrice(5000);
        album3.setArtist("작곡가1");

        Movie3 movie3 = new Movie3();
        movie3.setName("영화1");
        movie3.setPrice(10000);
        movie3.setDirection("감독1");
        movie3.setActor("주연1");

        Book3 book3 = new Book3();
        book3.setName("도서1");
        book3.setPrice(7000);
        book3.setAuthor("작가1");
        book3.setIsbn("책번호12345");

        em.persist(album3);
        em.persist(movie3);
        em.persist(book3);

        tx.commit();
    }
}