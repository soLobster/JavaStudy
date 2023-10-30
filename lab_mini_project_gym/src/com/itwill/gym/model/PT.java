package com.itwill.gym.model;

//DB PT 테이블의 컬럼을 정의하는 모델 클래스.

public class PT {

    private Integer pt_Code; //PK (none sequence)
    private Integer t_Id; //FK (GYM_TRAINER)
    private Integer pt_price;
    private Integer pt_time;
    private String pt_category;
    
    public PT() {}

    public PT(Integer pt_Code, Integer t_Id, Integer pt_price, Integer pt_time, String pt_category) {
        this.pt_Code = pt_Code;
        this.t_Id = t_Id;
        this.pt_price = pt_price;
        this.pt_time = pt_time;
        this.pt_category = pt_category;
    }

    public Integer getPt_code() {
        return pt_Code;
    }

    public void setPt_code(Integer pt_Code) {
        this.pt_Code = pt_Code;
    }

    public Integer getT_Id() {
        return t_Id;
    }

    public void setT_Id(Integer t_Id) {
        this.t_Id = t_Id;
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
        return "PT [pt_Code=" + pt_Code + ", t_Id=" + t_Id + ", pt_price=" + pt_price + ", pt_time=" + pt_time
                + ", pt_category=" + pt_category + "]";
    }
    
    
    
}
