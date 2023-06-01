package com.example.thymeleaf.beans;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserInfo {
    private String user_id;
    private String user_pw;
    private String user_name;
    private String user_birth;
}
