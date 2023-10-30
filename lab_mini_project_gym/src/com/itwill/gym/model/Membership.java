package com.itwill.gym.model;

// DB MEMBERSHIP 테이블의 컬럼을 정의하는 모델 클래스.

public class Membership {
    
    private Integer membershipcode; //pk
    private Integer membershiplength;
    private Integer membershipprice;
    private String membershipcategory;
    
    public Membership() {}

    public Membership(Integer membershipcode, Integer membershiplength, Integer membershipprice,
            String membershipcategory) {
        this.membershipcode = membershipcode;
        this.membershiplength = membershiplength;
        this.membershipprice = membershipprice;
        this.membershipcategory = membershipcategory;
    }

    public Integer getMembershipcode() {
        return membershipcode;
    }

    public void setMembershipcode(Integer membershipcode) {
        this.membershipcode = membershipcode;
    }

    public Integer getMembershiplength() {
        return membershiplength;
    }

    public void setMembershiplength(Integer membershiplength) {
        this.membershiplength = membershiplength;
    }

    public Integer getMembershipprice() {
        return membershipprice;
    }

    public void setMembershipprice(Integer membershipprice) {
        this.membershipprice = membershipprice;
    }

    public String getMembershipcategory() {
        return membershipcategory;
    }

    public void setMembershipcategory(String membershipcategory) {
        this.membershipcategory = membershipcategory;
    }

    @Override
    public String toString() {
        return "Membership [membershipcode=" + membershipcode + ", membershiplength=" + membershiplength
                + ", membershipprice=" + membershipprice + ", membershipcategory=" + membershipcategory + "]";
    }
    
    

}
