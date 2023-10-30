package com.itwill.gym.model;

//DB PT 테이블의 컬럼을 정의하는 모델 클래스.

public class PT {

    private Integer pt_code; //PK (none sequence)
    private Integer t_id; //FK (GYM_TRAINER)
    private Integer pt_price;
    private Integer pt_time;
    private String pt_category;
    
    public PT() {}

    public PT(Integer pt_code, Integer t_id, Integer pt_price, Integer pt_time, String pt_category) {
        this.pt_code = pt_code;
        this.t_id = t_id;
        this.pt_price = pt_price;
        this.pt_time = pt_time;
        this.pt_category = pt_category;
    }

    public Integer getPt_code() {
        return pt_code;
    }

    public void setPt_code(Integer pt_code) {
        this.pt_code = pt_code;
    }

    public Integer getT_id() {
        return t_id;
    }

    public void setT_id(Integer t_id) {
        this.t_id = t_id;
    }

    public Integer getPt_price() {
        return pt_price;
    }

    public void setPt_price(Integer pt_price) {
        this.pt_price = pt_price;
    }

    public Integer getPt_time() {
        return pt_time;
    }

    public void setPt_time(Integer pt_time) {
        this.pt_time = pt_time;
    }

    public String getPt_category() {
        return pt_category;
    }

    public void setPt_category(String pt_category) {
        this.pt_category = pt_category;
    }

    @Override
    public String toString() {
        return "PT [pt_code=" + pt_code + ", t_id=" + t_id + ", pt_price=" + pt_price + ", pt_time=" + pt_time
                + ", pt_category=" + pt_category + "]";
    }
    
    
    
}
