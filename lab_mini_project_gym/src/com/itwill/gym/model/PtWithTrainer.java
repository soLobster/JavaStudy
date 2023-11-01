package com.itwill.gym.model;
//join 한 테이블 모델.
public class PtWithTrainer {
    private int t_id;
    private String TrainerName;
    private int pt_price;
    private int pt_code;
    private int pt_time;
    private String pt_category;
    
    public PtWithTrainer() {}

    public PtWithTrainer(int t_id, String trainerName, int pt_price, int pt_code, int pt_time, String pt_category) {
        this.t_id = t_id;
        this.TrainerName = trainerName;
        this.pt_price = pt_price;
        this.pt_code = pt_code;
        this.pt_time = pt_time;
        this.pt_category = pt_category;
    }

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public String getTrainerName() {
        return TrainerName;
    }

    public void setTrainerName(String trainerName) {
        TrainerName = trainerName;
    }

    public int getPt_price() {
        return pt_price;
    }

    public void setPt_price(int pt_price) {
        this.pt_price = pt_price;
    }

    public int getPt_code() {
        return pt_code;
    }

    public void setPt_code(int pt_code) {
        this.pt_code = pt_code;
    }

    public int getPt_time() {
        return pt_time;
    }

    public void setPt_time(int pt_time) {
        this.pt_time = pt_time;
    }

    public String getPt_category() {
        return pt_category;
    }

    public void setPt_category(String pt_category) {
        this.pt_category = pt_category;
    }

   
}
