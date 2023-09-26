package com.itwill.view;

import java.util.Scanner;

import com.itwill.controller.MemberDaoImpl;

//MVC(Model-View-Controller) 아키텍쳐에서 view 역할 담당 클래스. - UI (입/출)

public class MemberMain {

    private Scanner scanner = new Scanner(System.in);
    private MemberDaoImpl dao = MemberDaoImpl.getInstance();// singleton 객체를 가져온다.
    
    public static void main(String[] args) {
        System.out.println("*** 회원 관리 프로그램 ***");

        MemberMain app = new MemberMain();

        boolean run = true; // 프로그램 종료할 때 false로 변경할 변수.
        while(run) {
            int menu = app.selectMainMenu();
            switch (menu) {
            case 0: // 종료...
                run = false;
                break;
            case 1: // 회원정보 전체 목록 보기.
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                System.out.println("*** 메뉴를 다시 선택하세요 ***");
            }
            System.out.println();
        }//end while...
        
        System.out.println("*** 프로그램 종료 ***");
    }//end main main...

    public int selectMainMenu() {
        System.out.println("\n-------------------------------------------------------------------------------");
        System.out.println("| 0) 종료 | 1) 전체목록 | 2) 새 회원 등록 | 3) 인덱스 검색 | 4) 비밀번호 변경 |");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println();
        System.out.print("선택 >> ");
        int menu = Integer.parseInt(scanner.nextLine());
        return menu;
    }
    
}//end class MemberMain...
