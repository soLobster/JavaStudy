package com.itwill.loop14;

import java.util.Scanner;

public class LoopMain14 {

    public static void main(String[] args) {
       //p162 연습문제 7
       
        boolean run = true; //프로그램을 계속 실행할 지, 종료할 지를 결정하는 변수.
        //run이 true인 경우 프로그램을 계속 실행, false인 경우에는 프로그램 종료.
        int balance = 0; // 은행 계좌 잔고를 저장할 변수. 
        // 변수가 while문 안에 있으면 안된다.
        
        Scanner scanner = new Scanner(System.in); //콘솔 입력 장치.
        
        
        
            while(run) {
                    System.out.println("-------------------------------------");
                    System.out.println("| 1.입금 | 2.출금 | 3.잔고 | 4.종료 |");
                    System.out.println("-------------------------------------");
                    System.out.print("메뉴를 선택하세요... >> ");
                        
                    int selectMenu = Integer.parseInt(scanner.nextLine());
                        
                    switch (selectMenu){
                        case 1: //입금 
                            System.out.print("입금액....>> ");
                            int depositMoney = Integer.parseInt(scanner.nextLine()); //입금액 입력.
                            balance += depositMoney; // 잔고에 입금액을 저장.
                            break;
                        case 2:
                            System.out.print("출금액....>> ");
                            int withdrawMoney = Integer.parseInt(scanner.nextLine());
                            balance -= withdrawMoney;
                            break;
                        case 3:
                            System.out.print("잔고....>> "+balance);
                            System.out.println();
                            break;
                        case 4:
                            System.out.println();
                            System.out.println("입출금을 종료합니다....");
                            run = false;
                            break;
                                
                            default:         
                            System.out.println();
                            System.out.println("메뉴를 다시 입력해주세요....");
                    }
                
            }
    }
    
}
