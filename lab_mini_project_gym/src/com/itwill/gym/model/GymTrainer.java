package com.itwill.gym.model;

import java.sql.Date;

// DB GYM_TRAINER 테이블의 컬럼을 정의하는 모델 클래스.

public class GymTrainer {

    private Integer t_Id; // 트레이너 번호 pk Sequence.
    private String t_name;
    private String t_phone;
    private String t_gender;
    private String t_email;
    private Integer salary;
    private Date birthday;
    private Date hiredate;
    private String t_address;
    
    public GymTrainer() {}

    public GymTrainer(Integer t_Id, String t_name, String t_phone, String t_gender, String t_email, Integer salary,
            Date birthday, Date hiredate, String t_address) {
        
        this.t_Id = t_Id;
        this.t_name = t_name;
        this.t_phone = t_phone;
        this.t_gender = t_gender;
        this.t_email = t_email;
        this.salary = salary;
        this.birthday = birthday;
        this.hiredate = hiredate;
        this.t_address = t_address;
    }

    public Integer getT_Id() {
        return t_Id;
    }

    public void setT_Id(Integer t_Id) {
        this.t_Id = t_Id;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public String getT_phone() {
        return t_phone;
    }

    public void setT_phone(String t_phone) {
        this.t_phone = t_phone;
    }

    public String getT_gender() {
        return t_gender;
    }

    public void setT_gender(String t_gender) {
        this.t_gender = t_gender;
    }

    public String getT_email() {
        return t_email;
    }

    public void setT_email(String t_email) {
        this.t_email = t_email;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public String getT_address() {
        return t_address;
    }

    public void setT_address(String t_address) {
        this.t_address = t_address;
    }

    @Override
    public String toString() {
        return "GymTrainer [t_Id=" + t_Id + ", t_name=" + t_name + ", t_phone=" + t_phone + ", t_gender=" + t_gender
                + ", t_email=" + t_email + ", salary=" + salary + ", birthday=" + birthday + ", hiredate=" + hiredate
                + ", t_address=" + t_address + "]";
    } 
    
    
    
    
}
