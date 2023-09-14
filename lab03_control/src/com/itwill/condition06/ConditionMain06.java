package com.itwill.condition06;

import java.util.Random; //Random 클래스를 사용하기 위해서.

public class ConditionMain06 {

    public static void main(String[] args) {
        // 조건문, 비교/논리 연산자 연습.
        
        //난수를 생성할 수 있는 Random 타입 변수를 선언, 초기화.
        
        Random random = new Random();
        int java = random.nextInt(101); // 0 이상 3 미만의 정수 난수를 만들고, java라는 변수에 저장.
        System.out.println("java: "+java);
        
        int sql = random.nextInt(101);
        System.out.println("sql: "+sql);
        
        int js = random.nextInt(101);
        System.out.println("js: "+js);
        
        //세 과목의 점수가 모두 40점 이상이고, 평균이 60점 이상이면 합격, 아니면 불합격.
        
        int examSum = java + sql + js;
        double examMean = examSum/3.0;
        
        if(java < 40 || sql < 40 || js < 40 ){
            System.out.println("과락 불합격");
        } else if(examMean < 60) {
            System.out.println("평균 불합격");
        } else {
            System.out.println("최종 합격");
        }
        
        
        if(java >=40 && sql >=40 && js >=40 && examMean >= 60.0) {
            System.out.println("합격 입니다.");
        } else {
            System.out.println("불합격 입니다.");
        }
        System.out.println("평균: "+examMean);
        
    }
}
