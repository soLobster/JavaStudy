package com.itwill.ver02.view;
import java.util.Scanner;
import com.itwill.ver02.controller.ContactDaoImpl;
import com.itwill.ver02.model.Contact;

//MVC(Model-View-Controller) 아키텍쳐에서 view 역할 담당 클래스. - UI (입/출)

public class ContactMain02 {

	private Scanner scanner = new Scanner(System.in);
	private ContactDaoImpl dao = ContactDaoImpl.getInstance();

	public static void main(String[] args) {
		System.out.println("------연락처 ver 0.2 ------");
		ContactMain02 app = new ContactMain02();

		boolean run = true;

		while(run) {
			int menu = app.showMainMenu();

			switch(menu) {
			case 0: // 프로그램 종료...
				run = false;
				System.out.println("=> 프로그램을 종료 합니다....!\n");
				break;
			case 1: // 연락처 목록 불러오기....            
				app.readAllContacts();
				break;
			case 2: // 새 연락처 추가하기....
				app.createContact();
				break;
			case 3: // 저장된 연락처 검색하기....
				app.readContactByIndex();
				break;
			case 4: // 저장된 연락처 수정하기....
				app.updateContact();
				break;
			default: 
				System.out.println("> 올바른 메뉴를 선택해주세요(0~4) \n");
			}//end switch...

		}//end of while...
		System.out.println("------연락처 ver 0.2 ------");
	}//end of main...

<<<<<<< HEAD
    private void createContact() { //새로운 연락처를 저장하는 메서드.....
        if(!dao.isMemoryAvail()) {
            System.out.println("연락처가 꽉_찼습니다.....!\n");
            return;
        }
        System.out.println("=> 새로운 연락처를 저장합니다.....");
        System.out.print("이름을 입력하세요....>> ");
        String name = scanner.nextLine();
        System.out.print("번호를 입력하세요....>> ");
        String phone = scanner.nextLine();
        System.out.print("E-mail을 입력하세요....>> ");
        String email = scanner.nextLine();
=======
	private void updateContact() {
		if(dao.getCount()==0) {
			System.out.println("=> 저장된 연락처가 없습니다.");
			return;//메서드 종료!
		} else if(dao.getCount()!=0) {
			System.out.println("연락처를 업데이트 합니다.");
			System.out.print("변경할 연락처의 인덱스를 입력하세요...>> ");
			int index = Integer.parseInt(scanner.nextLine());
			if(index < 0 || index > dao.getCount()) {
				System.out.println();
				System.out.println("수정하고자 하는 인덱스값이 없어요...");
				System.out.println("정확한 값을 입력해 주세요...");
				return; //메서드 종료!
			}
			System.out.print("새로운 이름을 입력해주세요...>> ");
			String name = scanner.nextLine();
			System.out.print("새로운 번호를 입력해주세요...>> ");
			String phone = scanner.nextLine();
			System.out.print("새로운 이메일을 입력해주세요...>> ");
			String email = scanner.nextLine();
>>>>>>> 14d96e86fc58ef34c0b620f6c8b084e5640df7b9

			int result = dao.update(index,name,phone,email);

<<<<<<< HEAD
    private void readAllContacts() { //저장된 연락처를 불러오는 메서드...
        if(dao.getCount()==0) {
            System.out.println("=> 저장된 연락처가 없습니다.");
        } else if(dao.getCount()!=0) {
            System.out.println("=> 저장된 연락처(들)을/를 불러옵니다.....\n");
            System.out.println("-------연락처 목록-------");
=======
			if(result==1) {
				System.out.println("연락처 수정에 성공했습니다....!");
			} else {
				System.out.println("연락처 수정에 실패했습니다....!");
			}
		}
>>>>>>> 14d96e86fc58ef34c0b620f6c8b084e5640df7b9


<<<<<<< HEAD
    private int showMainMenu() { //메인 메뉴 표시 메서드....
=======
	}//end updateContact()
>>>>>>> 14d96e86fc58ef34c0b620f6c8b084e5640df7b9

	private void readContactByIndex() {
		if(dao.getCount() == 0) {
			System.out.println("=> 저장된 연락처가 없습니다.");
			return;//메서드 종료...
		} else if (dao.getCount()!=0) {
			System.out.println("=> 연락처를 검색합니다....\n");
			System.out.print("검색할 연락처의 인덱스를 입력하세요....>> ");
			int index = Integer.parseInt(scanner.nextLine());
			Contact person = dao.read(index);

			if(person != null) {
				System.out.println("검색 결과 >> "+person);
			} else {
				System.out.println("해당 인덱스는 없는 연락처 입니다....");
			}

		}
	}//end readContactByIndex method...

	private void createContact() {
		if(!dao.isMemoryAvail()) {
			System.out.println("연락처가 꽉_찼습니다.....!\n");
			return;//메서드 종료....
		}
		System.out.println("=> 새로운 연락처를 저장합니다.....");
		System.out.print("이름을 입력하세요....>> ");
		String name = scanner.nextLine();
		System.out.print("번호를 입력하세요....>> ");
		String phone = scanner.nextLine();
		System.out.print("E-mail을 입력하세요....>> ");
		String email = scanner.nextLine();

		Contact person = new Contact(name, phone, email);
		int result = dao.create(person);

		if(result==1) {
			System.out.println("=> 연락처 저장 성공....!\n");
		} else {
			System.out.println("=> 연락처 저장 실패....!\n");
		}

	}//end createContact Method....

	private void readAllContacts() {
		if(dao.getCount()==0) {
			System.out.println("=> 저장된 연락처가 없습니다.");
		} else if(dao.getCount()!=0) {
			System.out.println("=> 저장된 연락처(들)을/를 불러옵니다.....\n");
			System.out.println("-------연락처 목록-------");

			Contact[] contacts = dao.read();
			for(int i = 0; i<contacts.length; i++) {
				System.out.printf("%d) %s",i,contacts[i]).println();
			}
			System.out.println("-------------------------\n");
		}
	}//end readAllContacts Method....

	private int showMainMenu() {

		System.out.println("--------------------------------------------------------------");
		System.out.println("| 0) 종료 | 1) 목록 | 2) 새 연락처 | 3) 인덱스 검색 | 4)수정 |");
		System.out.println("--------------------------------------------------------------");
		System.out.println();
		System.out.print("메뉴를 선택하세요 >> ");
		int menu = Integer.parseInt(scanner.nextLine());
		return menu;

	}//end of showMainMenu Method....


}//end of class...
