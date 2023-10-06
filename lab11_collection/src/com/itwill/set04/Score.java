package com.itwill.set04;

import java.util.Objects;

public class Score {

    private int java;
    private int sql;
    private int web;

    public Score() {}

    public Score(int java, int sql, int web) {
        this.java = java;
        this.sql = sql;
        this.web = web;
    }

    public int getJava() {
        return java;
    }

    public void setJava(int java) {
        this.java = java;
    }

    public int getSql() {
        return sql;
    }

    public void setSql(int sql) {
        this.sql = sql;
    }

    public int getWeb() {
        return web;
    }

    public void setWeb(int web) {
        this.web = web;
    }

    //equals와 hashcode를 over_ride
    //java,sql,web의 값이 모두 같으면 equals가 true 리턴.
    
//    @Override
//    public boolean equals(Object obj) {
//        boolean result = false;
//        if(obj instanceof Score) {
//            Score s = (Score) obj;
//            boolean same = (s.java == this.java) && (s.sql == this.sql) && (s.web == this.web);
//            if(same) {
//                result = true;
//            } else {
//                result = false;
//            }
//        }
//        return result;
//    }
//
//    @Override
//    public int hashCode() {
//        return Integer.valueOf(java).hashCode() + 
//                Integer.valueOf(sql).hashCode() + 
//                Integer.valueOf(web).hashCode();
//    }


    @Override
    public String toString() {
        return "( Java = " +this.java+
                " SQL = "+this.sql+
                " WEB = "+this.web+
                " )";
    }

    @Override
    public int hashCode() {
        return Objects.hash(java, sql, web);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) // 객체의 주소값을 비교한다.
            return true;
        if (obj == null) // 객체가 null 값인지 체크
            return false;
        if (getClass() != obj.getClass()) // getClass는 instanceOf 와 비슷하다
            return false;
        Score other = (Score) obj;
        return java == other.java && 
                sql == other.sql && 
                web == other.web;
    }

}


