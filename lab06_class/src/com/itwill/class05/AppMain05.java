package com.itwill.class05;

import java.util.Scanner;

public class AppMain05 {

	public static void main(String[] args) {
		// Account

		//123456 계좌 초기 잔고 0.
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("계좌번호를 입력해주세요. >> ");
		int accountNum1 = Integer.parseInt(sc.nextLine());
		Account userOneAcc = new Account(accountNum1, 0);
		
	
		
		System.out.print("userOne 의 초기 잔고 >> "+userOneAcc.balance);	
		System.out.println();
		System.out.println("==============");
		//입금 .
		System.out.print("입금할 금액을 입력해주세요 >> ");
		int amount = Integer.parseInt(sc.nextLine());
		System.out.println(userOneAcc.deposit(amount));

		System.out.println("==============");
		
		//출금 15000.
		System.out.print("출금할 금액을 입력해주세요 >> ");
		amount = Integer.parseInt(sc.nextLine());
		System.out.println(userOneAcc.withdraw(amount));
		
		System.out.println("==============");
		System.out.print("입금할 계좌를 입력해주세요 >> ");
		int accountNum2 = Integer.parseInt(sc.nextLine());
		
		
		System.out.print("송금할 금액을 입력해주세요 >> ");
		amount = Integer.parseInt(sc.nextLine());
		
		Account userTwoAcc = new Account(accountNum2, 20000);
		System.out.println(userOneAcc.transfer(userTwoAcc, amount));
		System.out.println("**************************");
		
		userOneAcc.info();
	}

}
