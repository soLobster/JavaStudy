package com.itwill.ver04.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.itwill.ver03.controller.ContactDaoImpl;
import com.itwill.ver02.model.Contact;

public class ContactMain03 {

	private Scanner scanner = new Scanner(System.in);
	private ContactDaoImpl dao = ContactDaoImpl.getInstance();
	
	public static void main(String[] args) {

		ContactMain03 app = new ContactMain03();

		boolean run = true;
		while(run) {
			MainMenu menu = app.showMainMenu();

			switch(menu) {
			case QUIT:// 프로그램 종료...
				run = false;
				System.out.println("=> 프로그램을 종료 합니다....!\n");
				break;
			case SELECT_ALL: // 연락처 목록 불러오기....            
				app.readAllContacts();
				break;
			case CREATE: // 새 연락처 추가하기....
				app.createContact();
				break;
			case SELECT_BY_INDEX: // 저장된 연락처 검색하기....
				app.readContactByIndex();
				break;
			case UPDATE: // 저장된 연락처 수정하기....
				app.updateContact();
				break;
			case DELETE: //연락처 삭제....
				app.deleteContact();
				break;
			default: 
				System.out.println("> 올바른 메뉴를 선택해주세요(0~5) \n");
			}
		}
	}//end of main...

	
	private void deleteContact() {
		if(dao.isContainContacts()) {
			System.out.println(">> 연락처를 삭제합니다....");
			System.out.print("삭제할 연락처의 인덱스를 입력하세요....>> ");
			int index = Integer.parseInt(scanner.nextLine());

			int removeContact = dao.delete(index);
			
			if(removeContact==1) {
				System.out.println(">> 연락처 삭제 성공....!");
			} else {
				System.out.println(">> 연락처 삭제 실패....!");
			}
		} else if(!dao.isContainContacts()) {
			System.out.println(">> 저장된 연락처가 없습니다....");
		}
	}//end of deleteContact()...

	private void updateContact() {
		if(dao.isContainContacts()) {
			System.out.println(">> 연락처를 수정합니다...");
			System.out.print("수정할 연락처의 인덱스를 입력하세요....>> ");
			int index = Integer.parseInt(scanner.nextLine());
			if(dao.isValidIndex(index)) {
				System.out.print("새로운 이름을 입력해주세요...>> ");
				String name = scanner.nextLine();
				System.out.print("새로운 번호를 입력해주세요...>> ");
				String phone = scanner.nextLine();
				System.out.print("새로운 이메일을 입력해주세요...>> ");
				String email = scanner.nextLine();

				Contact afterInfo = new Contact(name, phone, email);

				int result = dao.update(index, afterInfo);

				if (result == 1) {
					System.out.println("> 연락처 업데이트 성공");
				} else {
					System.out.println("> 연락처 업데이트 실패");
				}
			}
		} else if(!dao.isContainContacts()) {
			System.out.println(">> 저장된 연락처가 없습니다....");
		}
	}//end updateContact()...

	private void readContactByIndex() {
		if(dao.isContainContacts()) {
			System.out.println(">> 연락처를 찾겠습니다....");
			System.out.print("찾고자하는 연락처의 인덱스를 입력해주세요... >> ");
			int index = Integer.parseInt(scanner.nextLine());
			Contact readContact = dao.read(index);

			if(readContact != null) {
				System.out.println("검색결과 >> \n"+readContact);
			} else {
				System.out.println("없는 인덱스 입니다....");
			}
		} else if (!dao.isContainContacts()){
			System.out.println(">> 저장된 연락처가 없습니다....");
		}
	}//end readContactByindex()....

	private void createContact() {
		System.out.println(">> 연락처를 저장합니다...");
		System.out.print("이름을 입력해주세요....>> ");
		String name = scanner.nextLine();
		System.out.print("번호를 입력하세요....>> ");
		String phone = scanner.nextLine();
		System.out.print("E-mail을 입력하세요....>> ");
		String email = scanner.nextLine();

		int result = dao.create(new Contact(name, phone, email));

		if(result == 1) {
			System.out.println(">> 연락처 저장 성공.....!\n");
		} else {
			System.out.println(">> 연락처 저장 실패.....!\n");
		}
	}//end createContact method...

	private void readAllContacts() {
		if(dao.isContainContacts()) {
			System.out.println(">> 저장된 연락처를 불러옵니다.....");
			List<Contact> contacts = dao.read();
			for(Contact contact : contacts) {
				System.out.println(contact);
			} 
		} else if(!dao.isContainContacts()) {
			System.out.println(">> 저장된 연락처가 없습니다.....");
		}
	}//end readAllContacts....

	private MainMenu showMainMenu() {
		System.out.println("Welcome to CONTACT 0.3v");
		System.out.println("1. Read All Contacts");
		System.out.println("2. Add New Contact");
		System.out.println("3. Search Contact");
		System.out.println("4. Update Contact");
		System.out.println("5. Delete Contact");
		System.out.println("0. Exit CONTACT 0.3v");
		System.out.print("Enter your choice >> ");
		int n = InputInteger();

		return MainMenu.getMenu(n);
	}//end showMainMenu()....


    private int InputInteger() {
        int n = 0;
        while (true) {
            try {
                n = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.print("정수 입력> ");
            }
        }
        
        return n;
    }

}//end of class...
