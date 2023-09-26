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
                break;
            case 3: // 저장된 연락처 검색하기....
                break;
            case 4: // 저장된 연락처 수정하기....
                break;
            default: 
                System.out.println("> 올바른 메뉴를 선택해주세요(0~4) \n");
            }//end switch...

        }//end of while...
        System.out.println("------연락처 ver 0.2 ------");
    }//end of main...

    private void readAllContacts() {
        System.out.println("=> 저장된 연락처(들)을/를 불러옵니다.....\n");
        System.out.println("-------연락처 목록-------");
        
        Contact[] contacts = dao.read();
        for(int i = 0; i<contacts.length; i++) {
            System.out.printf("%d) %s",i,contacts[i]).println();
        }
        System.out.println("-------------------------\n");
    }//end readAllContacts Method....

    private int showMainMenu() {

        System.out.println("--------------------------------------------------------------");
        System.out.println("| 0) 종료 | 1) 목록 | 2) 새 연락처 | 3) 인덱스 검색 | 4)수정 |");
        System.out.println("--------------------------------------------------------------");
        System.out.println();
        System.out.print("메뉴를 선택하세요 >> ");
        int menu = Integer.parseInt(scanner.nextLine());
        return menu;

    }//end of showMainMenu....


}//end of class...
