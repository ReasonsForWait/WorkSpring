package org.example;

import org.example.repository1.Member1;
import org.example.repository1.Team1;

import javax.persistence.*;
import java.util.List;

public class Main3 {
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

        for (int i = 0 ; i < 30 ; i++){
            Member1 member1 = new Member1();
            member1.setUsername("member"+i);
            member1.setAge(20+i);
            if(i%2 == 0){
                member1.setTeam(team1);
            }else{
                member1.setTeam(team2);
            }
            em.persist(member1);
        }

        tx.commit();
    }

    // 페이징 처리 예제 1
    private static void logic1_2(EntityTransaction tx, EntityManager em) {
        tx.begin();

        TypedQuery<Member1> query1 = em.createQuery("select m from Member1 m", Member1.class);
        query1.setFirstResult(10); // 시작할 인덱스
        query1.setMaxResults(20); // 갯수

        System.out.println("------------------------페이징 예제 1----------------------");
        for (Member1 m1 : query1.getResultList()){
            System.out.println("name : "+m1.getUsername()+"   age : "+m1.getAge());
        }

        // 그룹 함수 예제 1
        Query query2 =  em.createQuery(
                "SELECT t.name, COUNT(m.age), SUM(m.age), AVG(m.age), MAX(m.age), MIN(m.age) \n" +
                        "FROM Member1 m LEFT JOIN m.team t \n" +
                        "GROUP BY t.name \n" +
                        "HAVING COUNT(m.age) >= 10");
        List<Object[]> list2 = query2.getResultList();

        System.out.println("----------그룹 함수 예제 1-------------");
        for(Object[] row : list2){
            String username = (String)row[0];
            Long count = (Long)row[1];
            Long sum = (Long)row[2];
            Double avg = (Double)row[3];
            Integer max = (Integer)row[4];
            Integer min = (Integer)row[5];
            System.out.println("name : "+username+"   count : "+count+"   sum : "+sum+"   avg : "+avg+
                    "   max : "+max+"   min : "+min);
        }

        // 정렬 예제
        TypedQuery<Member1> query3 = em.createQuery("select m from Member1 m order by m.age desc", Member1.class);
        query3.setFirstResult(10);
        query3.setMaxResults(10);

        System.out.println("------------정렬 예제 1--------------");
        for (Member1 m2: query3.getResultList()) {
            System.out.println("name : "+m2.getUsername()+"   age : "+m2.getAge());
        }

        tx.commit();
    }
}
