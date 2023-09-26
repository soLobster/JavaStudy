package com.itwill.model;

//MVC 아키텍처에서 Model 역할 담당하는 클래스 - 데이터 클래스 
//VO(Value Object) DTO(Data Transfer Object)..

public class Member {
    //field
    private String id;
    private String pwd;

    public Member() {}
    //기본 생성자...

    public Member(String id, String pwd) {
        this.id = id;
        this.pwd = pwd;
    }//아규먼트 생성자...


    //getter/setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {

        return "Member ( id = "+this.id+", pwd = "+this.pwd+" )";
    }//over_ride toString.

}
