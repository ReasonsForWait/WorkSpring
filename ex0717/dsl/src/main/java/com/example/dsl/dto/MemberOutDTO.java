package com.example.dsl.dto;

import com.example.dsl.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 어플리케이션으로 요청에 대한 응답을 저장하는 DTO
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberOutDTO {
    private Long userid;
    private String username;
    private Integer age;

    public MemberOutDTO(Member member) {
        userid = member.getId();
        username = member.getUsername();
        age = member.getAge();
    }

    public void setMember(Member member){
        userid = member.getId();
        username = member.getUsername();
        age = member.getAge();
    }
}
