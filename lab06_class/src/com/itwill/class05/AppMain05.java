package com.itwill.class05;

import java.util.Scanner;

public class AppMain05 {

	public static void main(String[] args) {
		// Account
		
    Account ac1 = new Account(123456, 50000);
    System.out.println("ac1 의 초기 잔고 >> "+ac1.balance);
    //123456 계좌 초기 잔고 50000.
    
    System.out.println(ac1.deposit(20000));
    //123456계좌 입금 20000원.
    System.out.println("==============");
    
    System.out.println(ac1.withdraw(10000));
    //123456 계좌 출금 10000원.
    System.out.println("==============");
    Account ac2 = new Account(654321, 0);
    System.out.println(ac1.transfer(654321, 20000));
	
    System.out.println("==============");
    ac1.info();
	}

}
