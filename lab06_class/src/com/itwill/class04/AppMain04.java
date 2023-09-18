package com.itwill.class04;


public class AppMain04 {

    public static void main(String[] args) {
        //Score 객체를 기본 생성자를 사용해서 생성.
        Score score1 = new Score();
        System.out.println(score1.korean);
        System.out.println(score1.english);
        System.out.println(score1.math);
        System.out.println(score1.getTotal());
        System.out.println(score1.getMean());
        
        System.out.println("==============");
        
        //Score 객체를 아규먼트를 갖는 생성자를 이용해서 생성.
        Score score2 = new Score(100, 70, 50);
        System.out.println(score2.korean);
        System.out.println(score2.english);
        System.out.println(score2.math);
        System.out.println(score2.getTotal());
        System.out.println(score2.getMean());
        
        //기본 생성자를 사용해서 Student 타입 객체 생성.
        Student std1 = new Student();
        System.out.println(std1);
        std1.studentNo = 10;
        std1.StudentName = "mount";
        std1.score = new Score(100,70,80);
//        System.out.println(std1.StudentName);
//        System.out.println(std1.studentNo);
//        System.out.println(std1.score.korean);
//        System.out.println(std1.score.english);
//        System.out.println(std1.score.math);
//        System.out.println(std1.score.getTotal());
//        System.out.println(std1.score.getMean());
        std1.studentInfo();
    }

}
