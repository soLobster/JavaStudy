package com.itwill.condition03;

import java.util.Scanner; // java.util 패키지에서 선언된 Scanner 클래스 이름을 사용하기 위해서.

public class ConditionMain03 {

    public static void main(String[] args) {
        //키보드에서 입력받은 값을 저장하는 방법.
        
        //1) Scanner 타입으로 변수를 선언하고, Scanner 객체를 저장. - 입력 도구 만듦.
        Scanner sc = new Scanner(System.in);
        
        //2) 키보드에서 정수를 입력받아서 int 타입 변수에 저장.
        System.out.print("JAVA 점수를 입력하세요 >>>> ");
        int java = sc.nextInt(); 
        System.out.print("SQL 점수를 입력하세요 >>>> ");
        int sql = sc.nextInt(); 
        System.out.print("JS 점수를 입력하세요 >>>> ");
        int js = sc.nextInt(); 
        System.out.println("당신의 JAVA 점수 >>>> "+java);     
        System.out.println("당신의 SQL 점수 >>>> "+sql);     
        System.out.println("당신의 JS 점수 >>>> "+js);     
        
        int examSum = java+sql+js;
        
        System.out.println("시험 점수의 총점 >> " +examSum);
        
        double examAvg = examSum/3.0;
        //double examAvg = (double) examSum/3
        
        System.out.printf("시험 점수의 평균 >> %.4f\n", examAvg);
        
        System.out.println("============성적=============");
        
        if(examAvg>=90) {
            System.out.println("당신의 성적은 A 입니다.");
        } else if (examAvg>=80) {
            System.out.println("당신의 성적은 B 입니다.");
        } else if (examAvg>=70) {
            System.out.println("당신의 성적은 C 입니다.");
        } else {
            System.out.println("당신의 성적은 F 입니다.");
        }
        
        //3) SQL 과목의 점수를 입력 받고 변수에 저장.
        // JS 과목의 점수를 입력 받고 변수에 저장.
        // 3과목의 점수를 출력. (JAVA,SQL,JS)
        // 3과목의 총점을 계산해서 출력.
        // 3과목의 평균을 계산해서 출력.(소수점까지)
        // 3과목의 평균이 90점 이상이면 A
        // 평균이 80점 이상이면 B
        // 나머지는 70점 이상이면 C
        // 그외 F.
        sc.close();
    }
}
