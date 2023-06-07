package com.example.thymeleaf.beans;


import java.util.List;

public class UserDTO {
    private String user_id;
    private String user_pw;
    private String user_name;
    private String user_birth;
    private Boolean user_chk;

    private List<String> states;

    public List<String> getStates() {
        return states;
    }

    public void setStates(List<String> states) {
        this.states = states;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_pw() {
        return user_pw;
    }

    public void setUser_pw(String user_pw) {
        this.user_pw = user_pw;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_birth() {
        return user_birth;
    }

    public void setUser_birth(String user_birth) {
        this.user_birth = user_birth;
    }

    public Boolean getUser_chk() {
        return user_chk;
    }

    public void setUser_chk(Boolean user_chk) {
        this.user_chk = user_chk;
    }
}
