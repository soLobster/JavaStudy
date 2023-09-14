package com.itwill.condition02;

public class ConditionMain02 {

    public static void main(String[] args) {
        //중첩조건문 if or else 블록 안에 또다른 조건문이 있는 경우.
            double x = -3.14;
        
            if(x>0) {
                System.out.println("X는 양수입니다.");    
            } else {
                if(x<0) {
                    System.out.println("X는 음수입니다.");
                } else {
                    System.out.println("X는 0입니다.");
                }
            }
        }
}