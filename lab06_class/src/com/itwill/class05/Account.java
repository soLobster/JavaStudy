package com.itwill.class05;



//은행계좌라는 클래스 
/**
 * 은행계좌정보
 * 속성: 계좌번호(int), 잔고(int)
 * 기능: 입금, 출금, 이체, 정보 출력.
 */
public class Account {
	//필드 
	int accountNum;
	int balance;
	int amount;
	
	//생성자(기본 생성자 X) 
	//argument 2개 갖는 생성자..
	//public 다른 클래스에서 사용할 수 있다.....
	//생성자의 이름은 클래스와 동일하다.
	public Account(int accountNum, int balance){
		this.accountNum = accountNum;
		this.balance= balance;
	}//생성자 생성....

	
	//메소드 - 기능.
	/**
	 * deposit(입금)
	 * @param amount(입금액)
	 * @return 입금 후 잔액
	 * 
	 */
	public int deposit(int amount) {
		System.out.print("입금한 금액 >> "+amount);
		this.balance += amount;
		System.out.println();
		System.out.print("입금후 잔고 >> ");
		return this.balance;
	}
	/**
	 * withdraw(출금).
	 * @param amount 출금액
	 * @return 출금 후 잔액.
	 */
	public int withdraw(int amount) {
		System.out.print("출금할 금액 >> "+amount);
		if(amount > 0) {
		this.balance -= amount;
		} else {
            System.out.println("출금액은 0보다 커야합니다.");
        }
		System.out.println();
		System.out.print("출금후 잔액 >> ");
		return balance;
	}
	
	/**
	 * transfer(이체). 내 계좌에서는 잔액에 amount를 빼주고, 상대방 계좌에서는 잔액에 amount를 더해준다.
	 * @param to 이체할 계좌(Account 타입(계좌)).
	 * @param amount 이체할 금액.
	 * @return true.boolean (이체 성공,실패). 무조건 true를 리턴하자...
	 */
	public boolean transfer(Account anoterAcc, int amount) {
		System.out.print("이체한 금액 >> "+amount);
		System.out.println();
		this.balance -= amount; //내 계좌에서 출금....
		anoterAcc.balance += amount;
		/**
		 * this.balance -= amount;
		 * another.balance += amount;
		 * this.withdraw(amount);
		 * another.deposit(amount);
		 * 
		 * 
		 * boolean result =false; //이체 실패했을 때 return값...
		 * if(amount>0) {
    	 *     if(amount <= this.balance){
    	 *         this.withdraw(amount);
    	 *         another.deposit(amount);
    	 *         result = true; //이체 성공 반환 값.
         *          } else {
         *              System.out.println("이체하기 위한 잔고가 부족합니다....")
         *           }
		 *    } else {
		 *            System.out.println("이체할 금액은 0보다 커야 합니다....")
		 *        }
		 * return result;
		 */
		System.out.print("이체후 잔액 >> "+balance);
		System.out.println();
		return true;
	}
	
	/**
	 * info(정보)
	 * 계좌번호, 현재 잔액을 출력.
	 */
	public void info() {
		System.out.println("---계좌 안내---");
		System.out.println("계좌번호 >> "+this.accountNum);
		System.out.println("현재잔액 >> "+this.balance);
	}
	
}
