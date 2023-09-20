package com.itwill.ver01;

//연락처 데이터 클래스...
public class Contact {

    //필드 private
    private String name;
    private String phone;
    private String email;

    //생성자
    public Contact() {} //기본 생성자....

    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }//아규먼트를 갖는 생성자....


    //getter,setter

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
}
