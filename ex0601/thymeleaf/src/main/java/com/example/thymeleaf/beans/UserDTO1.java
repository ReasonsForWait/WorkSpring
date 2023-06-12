package com.example.thymeleaf.beans;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO1 {
    private String name;
    private Integer num;
    private Double fl;
    private Boolean bool;
}
