package com.example.h0524Login;

public class Member {
    private String name;
    private String email;
    private String password;

    private String age;

    private String career;

    private String major;

    private String[] interest;

    public void setAge(String age) {
        this.age = age;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setInterest(String[] interest) {
        this.interest = interest;
    }

    public String getAge() {
        return age;
    }

    public String getCareer() {
        return career;
    }

    public String getMajor() {
        return major;
    }

    public String[] getInterest() {
        return interest;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
