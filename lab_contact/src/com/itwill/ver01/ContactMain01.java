package com.itwill.ver01;

import java.util.Scanner;

public class ContactMain01 {
    public static final int MAX_LENGTH = 5; //배열의 길이(원소 개수).

    private Scanner scanner = new Scanner(System.in); //입력 도구....
    private Contact[] contacts = new Contact[MAX_LENGTH]; //연락처들을 저장할 배열...
    private int count = 0; //배열 contacts에 저장된 연락처 개수를 저장하는 변수.....
    //배열에 새로운 연락처가 저장될 때마다 1씩 증가시킨다.... count++  / count--

    public static void main(String[] args) {
        System.out.println("---------*****---------연락처 v0.1-----------*****--------");
        ContactMain01 app = new ContactMain01();

        boolean run = true; //프로그램 실행/종료 여부......

        while(run) {

            int menu = app.showMainMenu();

            switch (menu) {
            case 0: //종료 케이스....
                run = false;
                System.out.println("프로그램을 종료합니다.");
                break;
            case 1: //배열에 저장된 전체 목록 출력...
                app.readAllContacts();
                break;
            case 2: //새 연락처 등록....
                app.createContact();
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                System.out.println("올바른 메뉴를 선택해주세요(0~4) :) ");
            }//end of switch...

        }//end of while...

        System.out.println();
        System.out.println("--------*****---------^^좋은하루^^---------*****---------");
    }//end of main...

    private void readAllContacts() {
        System.out.println("저장된 연락처를 표기합니다.");
        System.out.println();
        System.out.println("연락처 목록----");
        for(int i = 0; i<count; i++) { //배열에 실제로 저장된 연락처 개수만큼 반복....
            System.out.printf("%d) %s",i,contacts[i].toString()).println();
        }
        System.out.println("---------------");
        System.out.println();
    }//end of readAllContacts method....


    private void createContact() { 
        System.out.println("연락처를 저장합니다.");
        System.out.print("이름을 입력해주세요 >> ");
        String name = scanner.nextLine();
        System.out.print("번호를 입력해주세요 >> ");
        String number = scanner.nextLine();
        System.out.print("E-Mail을 입력해주세요 >> ");
        String email = scanner.nextLine();
        
        Contact c = new Contact(name, number, email); //String 3개를 저장하는 객체 C....
        contacts[count] = c; //연락처 객체를 배열에 저장...
        count++; //배열에 저장된 연락처 개수를 1 증가...!!!
    }//end of createContact....


    private int showMainMenu() {
        System.out.println("----------------------------------------------------------");
        System.out.println("  0.종료 | 1.목록 | 2.새 연락처 | 3.인덱스 검색 | 4.수정  ");
        System.out.println("----------------------------------------------------------");
        System.out.println();
        System.out.print("메뉴를 선택하세요 >> ");
        int menu = Integer.parseInt(scanner.nextLine());
        return menu;
    }//end of showMainMenu....


}//end of class...
