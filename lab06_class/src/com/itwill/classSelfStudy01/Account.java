package com.itwill.classSelfStudy01;

public class Account {

	String accountNumber;
	int balance;
	//필드 선언....


	public Account(String accountNumber, int balance) {
		this.accountNumber = accountNumber;
		this.balance = balance;
	}//생성자 Account....


	public void deposit(int amount) {
		if (amount > 0) {
			balance += amount;
			System.out.println(amount + "원 입금되었습니다.");
		} else {
			System.out.println("올바른 금액을 입력하세요.");
		}
	}//end deposit method...

	public void withdraw(int amount) {
		if (amount > 0 && amount <= balance) {
			balance -= amount;
			System.out.println(amount + "원 출금되었습니다.");
		} else {
			System.out.println("잔액이 부족하거나 올바른 금액을 입력하세요.");
		}
	}//end withdraw method....

	public void transfer(Account recipient, int amount) {
		if (amount > 0 && amount <= balance) {
			balance -= amount;
			recipient.deposit(amount);
			System.out.println(amount + "원 송금되었습니다.");
		} else {
			System.out.println("잔액이 부족하거나 올바른 금액을 입력하세요.");
		}
	}

	public int getBalance() {
		return balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}
}//end Account Class...
