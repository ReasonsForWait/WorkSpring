package org.example;

import org.example.repository1.Member1;
import org.example.repository1.Team1;

import javax.persistence.*;
import java.util.List;

// 조인 예제

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

        Team1 team1 = new Team1();
        team1.setName("팀1");
        em.persist(team1);

        Team1 team2 = new Team1();
        team2.setName("팀2");
        em.persist(team2);

        Team1 team3 = new Team1();
        team3.setName("팀3");
        em.persist(team3);

        Team1 team4 = new Team1();
        em.persist(team4);

        Member1 member1 = new Member1();
        member1.setUsername("member1");
        member1.setAge(15);
        member1.setTeam(team1);
        team1.getMembers().add(member1);
        em.persist(member1);

        Member1 member2 = new Member1();
        member2.setUsername("member2");
        member2.setAge(19);
        member2.setTeam(team1);
        team1.getMembers().add(member2);
        em.persist(member2);

        Member1 member3 = new Member1();
        member3.setUsername("member3");
        member3.setAge(17);
        member3.setTeam(team2);
        team2.getMembers().add(member3);
        em.persist(member3);

        Member1 member4 = new Member1();
        member4.setUsername("member4");
        member4.setAge(22);
        member4.setTeam(team2);
        team2.getMembers().add(member4);
        em.persist(member4);

        Member1 member5 = new Member1();
        member5.setUsername("member5");
        member5.setAge(20);
        em.persist(member5);

        tx.commit();
    }

    private static void logic1_2(EntityTransaction tx, EntityManager em) {
        tx.begin();

        // 내부 조인 예제 1
        Query query1 = em.createQuery("SELECT m.username, t.name FROM Member1 m INNER JOIN m.team t");

        System.out.println("--------------내부 조인 예제 1-----------------");
        for (Object[] row : (List<Object[]>)query1.getResultList()) {
            System.out.println("name : "+row[0]+"   teamname : "+row[1]);
        }

        // 외부 조인 예제 1
        Query query2 = em.createQuery("SELECT m.username, t.name FROM Member1 m LEFT JOIN m.team t");

        System.out.println("--------------외부 조인 예제 1-----------------");
        for (Object[] row : (List<Object[]>)query2.getResultList()) {
            System.out.println("name : "+row[0]+"   teamname : "+row[1]);
        }
        
        // 컬렉션 조인 예제 1
        Query query3 = em.createQuery("SELECT m.username, t.name FROM Team1 t LEFT JOIN t.members m");

        System.out.println("--------------컬렉션 조인 예제 1-----------------");
        for (Object[] row : (List<Object[]>)query3.getResultList()) {
            System.out.println("name : "+row[0]+"   teamname : "+row[1]);
        }

        // on절 예제 1
        Query query4 = em.createQuery(
                "SELECT m.username, t.name FROM Member1 m LEFT JOIN m.team t ON t.name = '팀1'");

        System.out.println("--------------on절 예제 1-----------------");
        for (Object[] row : (List<Object[]>)query4.getResultList()) {
            System.out.println("name : "+row[0]+"   teamname : "+row[1]);
        }

        // 패치 조인 예제 1
        TypedQuery<Member1> query5 = em.createQuery(
                "select m from Member1 m INNER JOIN FETCH m.team", Member1.class);

        System.out.println("-------------패치 조인 예제 1----------------");
        for (Member1 m3 : query5.getResultList()){
            System.out.println("teamname : "+m3.getTeam().getName());
        }

        // 패치 컬렉션 조인 예제 1
        TypedQuery<Team1> query6 = em.createQuery(
                "select distinct t from Team1 t INNER JOIN t.members m", Team1.class);

        System.out.println("-----------------컬렉션 조인 예제 1 ------------------");

        for (Team1 t1 : query6.getResultList()) {
            System.out.println(t1);
            for (Member1 m : t1.getMembers()){
                System.out.println("->"+m);
            }
        }

        tx.commit();
    }

    private static void logic1_3(EntityTransaction tx, EntityManager em) {
        tx.begin();

        // n + 1 에러 예제
        TypedQuery<Team1> query1 = em.createQuery(
                "select t from Team1 t", Team1.class);

        for (Team1 t1 : query1.getResultList()) {
            System.out.println(t1);
            for (Member1 m1: t1.getMembers()) {
                System.out.println(m1);
            }
        }

        em.clear();

        // 카운트 값 변경 쿼리 예제
        TypedQuery<Integer> query2 =
                em.createQuery("SELECT t.members.size FROM Team1 t", Integer.class);
        List<Integer> list1 = query2.getResultList();

        for (Integer i1 : list1) {
            System.out.println("count : "+i1);
        }

        em.clear();

        // 서브쿼리 예제1
        TypedQuery<Member1> query3 =
                em.createQuery("select m from Member1 m "+
                        "where m.age > (select AVG(m2.age) from Member1 m2)",Member1.class);
        List<Member1> list2 = query3.getResultList();

        System.out.println("---------------서브쿼리 예제 1--------------------");
        for (Member1 m1:list2) {
            System.out.println("name : "+m1.getUsername()+"   age : "+m1.getAge());
        }

        // 서브쿼리 예제2
        TypedQuery<Member1> query4 =
                em.createQuery("select m from Member1 m "+
                        "where EXISTS (select t from m.team t where t.name = '팀1')",Member1.class);
        List<Member1> list4 = query4.getResultList();
        System.out.println("---------------서브쿼리 예제 2--------------------");
        for (Member1 m2:list4) {
            System.out.println("name : "+m2.getUsername()+"   age : "+m2.getAge());
        }


        tx.commit();
    }

}
