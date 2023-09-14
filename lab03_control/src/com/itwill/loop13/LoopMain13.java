package com.itwill.loop13;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
public class LoopMain13 {

    public static void main(String[] args) {
        System.out.println("p161 문제 (5)==============================");
    
        //p161 문5,6 FOR문 별찍기
        //문5
        for(int i=1; i<=4;i++) {
            for(int j=1; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("p161 문제 (6)=================");
        //문6
        for(int i=1; i<=4; i++) {
            for(int j=3; j>=i; j--) { //for(int j=1; j<=4-i; j++)
                System.out.print("_");
            }
            for(int k=1; k<=i; k++) { //for(int k=1; k<=i; k++)
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("p161 문제 (6)==다른방법======");
        for(int i=1; i<=4; i++) {
            for(int j=4; j>=1; j--) {
                if(j > i) {
                    System.out.print("_");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        
        System.out.println("p161 문제 (7)=================");

        
        System.out.println();
        System.out.println("p161 문제 (7)=================");
        System.out.println();
        

        boolean run = true;
        int balance = 0;
        Scanner sc = new Scanner(System.in);
        
        int mainMenu =0;
        int depositMoney =0;
        int lastMoney = 0;
        while(run) {
            System.out.println("---------------------------------");
            System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
            System.out.println("---------------------------------");
            System.out.print("선택( '1~4' 입력) > ");
            mainMenu = sc.nextInt();
            
            if(mainMenu==1) {
                System.out.print("예금액> ");
                balance += sc.nextInt();
                System.out.println();
            } else if(mainMenu==2) {
                System.out.print("출금액> ");
                depositMoney += sc.nextInt();
                System.out.println();
            } else if(mainMenu==3) {

                //balance = balance - depositMoney;
                //System.out.println();

                lastMoney = balance - depositMoney;
                System.out.print("잔고> " +lastMoney);
                System.out.println();
            } else {

                System.out.println();

            	System.out.println();

                System.out.println("프로그램 종료.");
                run = false;
                //break;
                
                
            }
            
        }
      
        
    }

}
