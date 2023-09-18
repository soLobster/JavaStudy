package com.itwill.class05;
//은행계좌라는 클래
/**
 * 은행계좌정보
 * 속성: 계좌번호(int), 잔고(int)
 * 기능: 입금, 출금, 이체, 정보 출력.
 */
public class Account {
	//필드 
	int accountNum;
	int balance = 0;
	int amount = 0;
	
	//생성자(기본 생성자 X) 
	//argument 2개 갖는 생성자..
	public Account(int accountNum, int balance){
		this.accountNum = accountNum;
		this.balance = balance;
	}
	
	//메소드
	/**
	 * deposit(입금)
	 * @param amount(입금액)
	 * @return 입금 후 잔액
	 * 
	 */
	public int deposit() {
		
		balance += amount;
		return balance;
	}
	/**
	 * withdraw(출금).
	 * @param amount 출금액
	 * @return 출금 후 잔액.
	 */
	public int withdraw() {
		balance -= amount;
		return balance;
	}
	
	/**
	 * transfer(이체).
	 * @param to 이체할 계좌(Account 타입(계좌)).
	 * @param amount 이체할 금액.
	 * @return true.boolean (이체 성공,실패). 무조건 true를 리턴하자...
	 */
	public boolean transfer() {
		
		return true;
	}
	
	/**
	 * info(정보)
	 * 계좌번호, 현재 잔액을 출력.
	 */
	public void info() {
		System.out.println("계좌번호 : "+accountNum);
		System.out.println("현재잔액 : "+balance);
	}
	
}
