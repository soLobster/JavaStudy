package com.itwill.classSelfStudy01;

import java.util.Scanner;

public class AppMainSelfStudy01 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("계좌번호1(을/를) 입력하세요 >> ");
		String accountNumber1 = scanner.nextLine();
		System.out.print("계좌번호(을/를) 입력하세요 >> ");
		String accountNumber2 = scanner.nextLine();
		
		// 계좌 생성
        Account account1 = new Account(accountNumber1, 1000);
        Account account2 = new Account(accountNumber2, 2000);

        while (true) {
            System.out.println("1. 입금 2. 출금 3. 송금 4. 계좌 확인 5. 종료");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("입금할 금액을 입력하세요: ");
                    int depositAmount = scanner.nextInt();
                    account1.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("출금할 금액을 입력하세요: ");
                    int withdrawAmount = scanner.nextInt();
                    account1.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("송금할 계좌 번호를 입력하세요: ");
                    String recipientAccountNumber = scanner.next();
                    Account recipientAccount = account2; // 계좌 번호로 찾아서 변경해야 함
                    System.out.print("송금할 금액을 입력하세요: ");
                    int transferAmount = scanner.nextInt();
                    account1.transfer(recipientAccount, transferAmount);
                    break;
                case 4:
                    System.out.println("계좌번호: " + account1.getAccountNumber());
                    System.out.println("잔액: " + account1.getBalance() + "원");
                    break;
                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("올바른 메뉴를 선택하세요.");
                    break;
            }
        }
 }
}