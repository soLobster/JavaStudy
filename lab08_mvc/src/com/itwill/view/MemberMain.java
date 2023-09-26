package com.itwill.view;
import java.util.Scanner;
import com.itwill.controller.MemberDaoImpl;
import com.itwill.model.Member;

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
                app.readAllMembers();
                break;
            case 2: // 새 회원 등록.
                app.createNewMember();
                break;
            case 3: // 인덱스 검색
                app.readMemberByIndex();
                break;
            case 4: // 비밀번호 수정..
                app.updatePassword();
                break;
            default:
                System.out.println("*** 메뉴를 다시 선택하세요 ***");
            }
            System.out.println();
        }//end while...

        System.out.println("*** 프로그램 종료 ***");
    }//end main...

    private void updatePassword() {
        System.out.println("\n-------비밀번호 변경하기-------");
        System.out.print("비밀번호를 변경할 회원 인덱스를 입력하세요...>> ");
        int index = Integer.parseInt(scanner.nextLine());

        if(!dao.isValidIndex(index)) {
            System.out.println("> 해당 인덱스는 없는 회원 정보임....");
            return; //메서드 종료...
        }

        System.out.print("새로운 비밀번호를 입력해 주세요...>> ");
        String pwd = scanner.nextLine();
        int result = dao.update(index, pwd);

        if(result == 1) {
            System.out.println("> 비밀번호 변경 성공....!");
        }else {
            System.out.println("> 비밀번호 변경 실패....!");

        }
    }//end updatePassword....

    public void readMemberByIndex() { //main에서만 사용할거면 접근 제어잘를 private 해도 상관 없다.
        System.out.println("\n-------회원 인덱스 검색하기-------");
        System.out.print("검색할 인덱스를 입력하세요...>> ");
        int index = Integer.parseInt(scanner.nextLine());
        Member m = dao.read(index);

        if(m != null) {
            System.out.println("결과 >> "+m);
        } else {
            System.out.println("> 해당 인덱스는 없는 회원 정보임....");
        }

        System.out.println("----------------------------------");
    }//end readMemberByIndex...

    public void createNewMember() {
        System.out.println("\n-------신규 회원 등록 하기-------");

        //id, pwd 입력전에 이미 배열이 꽉 찼는지 확인해주는 것이 필요

        System.out.print("Id를 입력하세요...>> ");
        String id = scanner.nextLine();
        System.out.print("pwd를 입력하세요...>> ");
        String pwd = scanner.nextLine();

        Member m = new Member(id, pwd);
        int result = dao.create(m);

        if(result == 1) {
            System.out.println(">> 신규 회원 등록 성공...!");
        } else {
            System.out.println(">> 신규 회원 등록 실패...!");
        }

    }//end registerNewMember...


    public void readAllMembers() {
        System.out.println("\n-----회원 전체 목록 보기 ---------");
        Member[] members = dao.read();
        //        for(Member m : members) {
        //            System.out.println(m);
        //        }
        for(int i = 0; i < members.length; i++) {
            System.out.printf("%d) %s",i,members[i]).println();
        }
        System.out.println("----------------------------------");
    }//end readAllMembers Method...

    public int selectMainMenu() {
        System.out.println("\n-------------------------------------------------------------------------------");
        System.out.println("| 0) 종료 | 1) 전체목록 | 2) 새 회원 등록 | 3) 인덱스 검색 | 4) 비밀번호 변경 |");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println();
        System.out.print("선택 >> ");
        int menu = Integer.parseInt(scanner.nextLine());
        return menu;
    }//end of selectMainMenu Method...



}//end class MemberMain...
