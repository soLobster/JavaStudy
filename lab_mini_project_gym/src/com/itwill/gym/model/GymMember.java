package com.itwill.gym.model;

import java.sql.Date;
import java.time.LocalDateTime;

// DB GYM_MEMBER 테이블의 컬럼들을 정의하는 모델 클래스.

public class GymMember {

    private Integer id; //회원 번호 pk Sequence.
    private String name;
    private String phone;
    private String gender;
    private Date birthday;
    private String address;
    private LocalDateTime joinTime;
    private LocalDateTime modifiedTime;

    public GymMember() {}

    public GymMember(Integer id, String name, String phone, String gender, Date birthday, String address,
            LocalDateTime joinTime, LocalDateTime modefiedTime) {
        super();
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
        this.joinTime = joinTime;
        this.modifiedTime = modefiedTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(LocalDateTime joinTime) {
        this.joinTime = joinTime;
    }

    public LocalDateTime getModefiedTime() {
        return modifiedTime;
    }

    public void setModefiedTime(LocalDateTime modefiedTime) {
        this.modifiedTime = modefiedTime;
    }

    @Override
    public String toString() {
        return "GymMember [id=" + id + ", name=" + name + ", phone=" + phone + ", gender=" + gender + ", birthday="
                + birthday + ", address=" + address + ", joinTime=" + joinTime + ", modifiedTime=" + modifiedTime + "]";
    }



}
