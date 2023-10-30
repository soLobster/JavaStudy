package com.itwill.gym.model;

// DB MEMBERSHIP 테이블의 컬럼을 정의하는 모델 클래스.

public class Membership {

    private Integer membership_code; //pk
    private Integer membership_numofdays;
    private Integer membership_price;
    private String membership_category;

    public Membership() {}

    public Membership(Integer membership_code, Integer membership_numofdays, Integer membership_price, String membership_category) {

        this.membership_code = membership_code;
        this.membership_numofdays = membership_numofdays;
        this.membership_price = membership_price;
        this.membership_category = membership_category;
    }

    public Integer getMembership_code() {
        return membership_code;
    }

    public void setMembership_code(Integer membership_code) {
        this.membership_code = membership_code;
    }

    public Integer getMembership_numofdays() {
        return membership_numofdays;
    }

    public void setMembership_numofdays(Integer membership_numofdays) {
        this.membership_numofdays = membership_numofdays;
    }

    public Integer getMembership_price() {
        return membership_price;
    }

    public void setMembership_price(Integer membership_price) {
        this.membership_price = membership_price;
    }

    public String getMembership_category() {
        return membership_category;
    }

    public void setMembership_category(String membership_category) {
        this.membership_category = membership_category;
    }

    @Override
    public String toString() {
        return "Membership [membership_code=" + membership_code + ", membership_numofdays=" + membership_numofdays
                + ", membership_price=" + membership_price + ", membership_category=" + membership_category + "]";
    }
}
