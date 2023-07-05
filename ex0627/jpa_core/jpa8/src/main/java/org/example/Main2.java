package org.example;

import org.example.repository4.Address4;
import org.example.repository4.Member4;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

        Member4 member1 = new Member4();
        member1.setName("member1");

        Set<String> foods = new HashSet<>();
        foods.add("양념돼지갈비");
        foods.add("냉면");
        foods.add("새우볼꼬치");

        member1.setFavoriteFood(foods);

        List<Address4> address = new ArrayList<>();
        address.add(new Address4("city1","street1", "1111"));
        address.add(new Address4("city2","street2", "2222"));

        Address4 address11 = new Address4("city1","street1", "1111");
        Address4 address12 = new Address4("city1","street1", "1111");

//        System.out.println(address11.equals(address12)); // ?

        member1.setAddressList(address);

        em.persist(member1);

        tx.commit();
    }

    private static void logic1_2(EntityTransaction tx, EntityManager em) {
        tx.begin();

        Member4 findMember = em.find(Member4.class, 1L);
        List<Address4> addresses = findMember.getAddressList();

        for (int i = 0 ; i < addresses.size() ; i++){
            if(addresses.get(i).getCity().equals("city1")){
                addresses.remove(i);
                addresses.add(new Address4("new city1", "new street1", "new1111"));
            }
        }

        tx.commit();
    }
}
