package com.itwill.condition01;

import java.util.Scanner;

public class ConditionMain01 {

    public static void main(String[] args) {
        //조건문(conditional statement)
        int num1;
        //int num2;
        Scanner sc1 = new Scanner(System.in);
        System.out.print("정수를 입력하세요: ");
        num1 = Integer.parseInt(sc1.next());
        
        if (num1%2==0) {
            System.out.println("짝수입니다."); //참인 경우 코드 블럭
        } else {
            System.out.println("홀수입니다.");
        }
        
        //Scanner sc2 = new Scanner(System.in);
        //System.out.print("2) 정수를 입력하세요: ");
        //num2 = Integer.parseInt(sc2.next());
        
        if (num1>0) {
            System.out.println("양수입니다."); //참인 경우 코드 블럭
        } else if(num1<0) {
            System.out.println("음수입니다.");
        } else {
            System.out.println("0을 입력하셨습니다.");
        }
        
    }

}
