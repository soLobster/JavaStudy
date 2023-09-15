package com.itwill.class01;

public class AppMain01 {

    public static void main(String[] args) {
        // 클래스 = 데이터 타입.
        Subject subject = new Subject(); //클래스 
        // 생성자 (constructor). : 클래스의 변수(필드)들을 초기화.        
        
        System.out.println(subject.java);
        System.out.println(subject.sql);
        System.out.println(subject.javaScript);
        
        subject.java = 100;
        subject.sql = 100;
        subject.javaScript = 50;
        
        System.out.println(subject.java);
        System.out.println(subject.sql);
        System.out.println(subject.javaScript);
        
        
    }

}
