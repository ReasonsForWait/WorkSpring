package com.example.dsl.repository.custom;

import com.example.dsl.domain.Member;
import com.example.dsl.domain.QMember;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.example.dsl.domain.QMember.member;
import static com.example.dsl.domain.QTeam.team;

public class MemberRepositoryCustomV1Impl implements MemberRepositoryCustomV1{

    private final JPAQueryFactory queryFactory;

    public MemberRepositoryCustomV1Impl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override // select m from Member m where m.username = "member1"
    public Member findMemberV1() {
        // 예제 1
//        QMember m = new QMember("m");
//        Member findMember = queryFactory
//                .select(m)
//                .from(m)
//                .where(m.username.eq("member1"))
//                .fetchOne();
        // 예제 2
//        QMember m = QMember.member;
//        Member findMember = queryFactory
//                .selectFrom(m)
//                .where(m.username.eq("member1"))
//                .fetchOne();
//        return findMember;
        // 예제 3
        return queryFactory
                .selectFrom(member)
                .where(member.username.eq("member1"))
                .fetchOne();
    }

    public Member findMemberV2(){
        return queryFactory
                .selectFrom(member)
                //.where(member.username.eq("member1").and(member.age.eq(10))) // 유저 이름이 member1 이고 age가 10인 사람
                .where(member.username.eq("member1"), member.age.eq(10))
                .fetchOne();
    }

    public List<Member> findMemberV3(){
        return queryFactory
                .selectFrom(member)
                .where(member.age.gt(10))
                .orderBy(member.age.desc(), member.username.asc().nullsLast())
                .fetch();
    }

    public List<Member> findMemberV4(){
        return queryFactory
                .selectFrom(member)
                .orderBy(member.username.desc())
                .offset(0)// 오프셋 정의, 시작은 0부터
                .limit(2) // 결과에 대한 제한/최대 결과를 정의
                .fetch();
    }

    // 그룹 함수
    public void findMemberV5(){
        List<Tuple> result = queryFactory
                .select(member.count(),
                        member.age.sum(),
                        member.age.avg(),
                        member.age.max(),
                        member.age.min())
                .from(member)
                .fetch();

        for (Tuple tuple :result){
            System.out.println("tuple = "+tuple);
            System.out.println(tuple.get(member.count()));
            System.out.println(tuple.get(member.age.sum()));
            System.out.println(tuple.get(member.age.avg()));
            System.out.println(tuple.get(member.age.max()));
            System.out.println(tuple.get(member.age.min()));
        }

    }

    // groupby, having
    public void findMemberV6(){
        List<Tuple> result = queryFactory
                .select(team.name, member.age.avg())
                .from(member)
                .join(member.team, team)
                .groupBy(team.name)
                .having(member.age.goe(member.age.avg()))
                .fetch();

        Tuple teamA = result.get(0);
        Tuple teamB = result.get(1);
        System.out.println(teamA.get(team.name));
        System.out.println(teamA.get(member.age.avg()));
        System.out.println(teamB.get(team.name));
        System.out.println(teamB.get(member.age.avg()));
    }

    public List<Member> findMemberV7(){
        return queryFactory
                .selectFrom(member)
                .join(member.team, team)
                .where(team.name.eq("team1"))
                .fetch();
    }

    // 연관관계가 없는 엔티티 외부 조인
    public void findMemberV8(){
        List<Tuple> result = queryFactory
                .select(member, team)
                .from(member)
                .leftJoin(team)
                .on(member.username.eq(team.name))
                .fetch();
    }
}
