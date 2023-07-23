package com.example.webjpa.dto;

import com.example.webjpa.domain.Member;
import com.example.webjpa.dto.spec.OutDTO;
import lombok.Data;

import java.util.UUID;

// 어플리케이션에서 요청한 정보를 받아와서 저장하는 DTO
@Data
public class MemberInDTO {
     private UUID userid;
     private UUID teamid;
     private String username;
     private Integer age;
     private String teamname;

     // Member 엔티티를 생성하는 메서드
//     public Member getMemberEntity(){
//         Member member = new Member(username, age);
//         member.setId(userid.longValue());
//         return member;
//     }
}
