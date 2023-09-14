package com.itwill.condition05;

import java.util.Scanner;

public class ConditionMain05 {

    public static void main(String[] args) {
        // 삼항연산자 연습
        System.out.print("숫자를 입력해주세요 >> ");
        Scanner scanner = new Scanner(System.in);
        /*
        int genderCode = scanner.nextInt();
        String gender = "";
        
        //genderCode의 값이 1이면 gender = "남성", genderCode의 값이 2이면 gender = "여성"
        //genderCode의 값은 1 또는 2만 가능하다고 가정.
        
        if(genderCode == 1) {
            gender = "남성";
            System.out.println(gender);
        } else {
            gender = "여성";
            System.out.println(gender);
        }
    
        gender = (genderCode == 1) ? "남성":"여성"; 
        System.out.println(gender);
        
        System.out.println("====================================================");
        
        */
        //짝수 홀수 구분
        //number가 짝수이면 evenOrOdd "짝수" 저장
        //number가 홀수이면 evenOrOdd "홀수" 저장
        int number = scanner.nextInt();
        String evenOrOdd = "";
        
        if(number%2 == 0) {
            evenOrOdd ="짝수";
            System.out.println(evenOrOdd);
        } else {
            evenOrOdd ="홀수";
            System.out.println(evenOrOdd);
        }
        
        evenOrOdd = (number%2 == 0) ? "짝수":"홀수";
        System.out.println(evenOrOdd);
        
        scanner.close();
    }

}
