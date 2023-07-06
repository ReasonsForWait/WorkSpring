package org.example;

import org.example.dto.UserDTO;
import org.example.repository1.*;

import javax.persistence.*;
import java.util.List;

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

        Team1 team1 = new Team1();
        team1.setName("팀1");
        em.persist(team1);

        Team1 team2 = new Team1();
        team2.setName("팀2");
        em.persist(team2);

        Member1 member1 = new Member1();
        member1.setUsername("member1");
        member1.setAge(19);
        member1.setTeam(team1);
        em.persist(member1);

        Member1 member2 = new Member1();
        member2.setUsername("member2");
        member2.setAge(15);
        member2.setTeam(team1);
        em.persist(member2);

        Member1 member3 = new Member1();
        member3.setUsername("member3");
        member3.setAge(17);
        member3.setTeam(team2);
        em.persist(member3);

        Product1 product1 = new Product1();
        product1.setName("칫솔");
        product1.setPrice(5000);
        product1.setStockAmount(100);
        em.persist(product1);

        Product1 product2 = new Product1();
        product2.setName("치약");
        product2.setPrice(3000);
        product2.setStockAmount(80);
        em.persist(product2);

        Address1 address1 = new Address1();
        address1.setCity("서울");
        address1.setStreet("마포로");
        address1.setZipcode("11111");

        Address1 address2 = new Address1();
        address2.setCity("경기");
        address2.setStreet("수원로");
        address2.setZipcode("22222");

        Order1 order1 = new Order1();
        order1.setAddress(address1);
        order1.setProduct(product1);
        order1.setOrderAmount(4);
        em.persist(order1);

        Order1 order2 = new Order1();
        order2.setAddress(address1);
        order2.setProduct(product2);
        order2.setOrderAmount(3);
        em.persist(order2);

        Order1 order3 = new Order1();
        order3.setAddress(address2);
        order3.setProduct(product1);
        order3.setOrderAmount(2);
        em.persist(order3);

        tx.commit();
    }

    // 엔티티 프로젝션
    private static void logic1_2(EntityTransaction tx, EntityManager em) {
        tx.begin();

        // 엔티티 프로젝션 예제 1
        TypedQuery<Member1> query1 = em.createQuery("select m from Member1 m", Member1.class);
        List<Member1> list1 = query1.getResultList();

        System.out.println("----------엔티티 프로젝션 예제 1---------");
        for (Member1 m1 : list1) {
            System.out.println("name : "+m1.getUsername()+"   age : "+m1.getAge());
        }

        // 엔티티 프로젝션 예제 2
        TypedQuery<Team1> query2 = em.createQuery("select distinct m.team from Member1 m", Team1.class);
        List<Team1> list2 = query2.getResultList();

        System.out.println("----------엔티티 프로젝션 예제 2---------");
        for (Team1 t1 : list2) {
            System.out.println("name : "+t1.getName());
        }

        // 임베디드 타입 프로젝션 1
        TypedQuery<Address1> query3 = em.createQuery("select distinct o.address from Order1 o", Address1.class);
        List<Address1> list3 = query3.getResultList();

        System.out.println("----------임베디드 타입 프로젝션 예제 1------------");
        for (Address1 addr1 : list3){
            System.out.println("zipcode : "+addr1.getZipcode()+"  city : "+addr1.getCity()+"   street : "+addr1.getStreet());
        }

        // 스칼라 타입 프로젝션 예제 1
        TypedQuery<String> query4 = em.createQuery("select m.username from Member1 m", String.class);
        List<String> list4 = query4.getResultList();

        System.out.println("----------스칼라 타입 프로젝션 예제 1------------");
        for (String str1 : list4){
            System.out.println("username : "+str1);
        }

        tx.commit();

        // 통계 쿼리에 대한 스칼라 데이터 예제 2
        TypedQuery<Double> query5 = em.createQuery("select AVG(o.orderAmount) from Order1 o",Double.class);
        Double avg1 = query5.getSingleResult();

        System.out.println("----------------------스칼라 타입 프로젝션 예제 2--------------------");
        System.out.println("avg1 : "+avg1);

        // new 스칼라 데이터 예제
        TypedQuery<UserDTO> query6 = em.createQuery(
                "select new org.example.dto.UserDTO(m.username, m.age, m.team) from Member1 m", UserDTO.class);

        System.out.println("----------------------스칼라 타입 프로젝션 예제 3--------------------");
        for(UserDTO dto1 : query6.getResultList()){
            System.out.println("name : "+ dto1.getUsername() + "   age : "+dto1.getAge());
        }

    }
}
