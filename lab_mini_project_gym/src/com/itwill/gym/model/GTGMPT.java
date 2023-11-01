package com.itwill.gym.model;
//3가지 조인 테이블 정의
public class GTGMPT {
    
    private String name;
    private String phone;
    private String gender;
    private String pt_category;
    
    public GTGMPT() {}

    public GTGMPT(String name, String phone, String gender, String pt_category) {
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        this.pt_category = pt_category;
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

    public String getPt_category() {
        return pt_category;
    }

    public void setPt_category(String pt_category) {
        this.pt_category = pt_category;
    }

    @Override
    public String toString() {
        return "GTGMPT [name=" + name + ", phone=" + phone + ", gender=" + gender + ", pt_category=" + pt_category
                + "]";
    }
    
    
}
