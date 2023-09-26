package com.itwill.ver02.model;

//MVC 아키텍처에서 Model 역할 담당하는 클래스 - 데이터 클래스 
//VO(Value Object) DTO(Data Transfer Object)..


public class Contact {
    //field
    private String name;
    private String phone;
    private String email;
    
    //constructor
    public Contact() {} // 기본 생성자....
    
    public Contact(String name, String Phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }// 아규먼트를 갖는 생성자....

    
    //getter, setter...
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String toString() { //연락처 정보(이름,번호,메일)을 문자열로 만들어서 리턴하는 메서드....
        return "Contact ( name = "+this.name+
                ", phone = "+this.phone+
                ", email = "+this.email+
                " )";
    }//toString over_ride...
    
}
