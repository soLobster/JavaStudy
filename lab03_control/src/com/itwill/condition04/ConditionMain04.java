package com.itwill.condition04;

public class ConditionMain04 {

    public static void main(String[] args) {
        //삼항 연산자.
        // int score = 95;
        // char grade = (score > 90) ? 'A' : 'B';
        // System.out.println(grade);
        
        //x와 y 중에서 더 큰 값을 big 변수에 저장.
        int x = 10;
        int y = 5;
        
        int big = (x > y) ? x:y;
        // (조건식) ? (조건식을 만족할 때 채택할 값):(조건식을 만족하지 못할 때 채택할 값)
        System.out.println(big);
        
        int x1 = 100;
        int y1 = 15;
        
        int big1;
        
        if(x1 > y1) {
            big1 = x1;
        } else {
            big1 = y1;
        }
        
        System.out.println(big1);
    } 

}
