package com.itwill.ver02.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.itwill.ver02.controller.InstagramDao;
import com.itwill.ver02.model.Instagram;

public class InstagramMain {

    private Scanner scanner = new Scanner(System.in);
    private InstagramDao dao = InstagramDao.getInstance();
    private ArrayList<Instagram> instagrams = new ArrayList<Instagram>();

    public static void main(String[] args) {

        InstagramMain app = new InstagramMain();
        boolean run = true;
        while(run) {
            int menu = app.showMainMenu();

            switch(menu) {
            case 0://exit program.
                run = false;
                System.out.println(">> Exit Instagram BYE-BYE");
                break;
            case 1://인스터 회원 가입....
                app.InstaSignUp();
                break;
            case 3://인스타 아이디, 비밀번호 조회
                app.InstaFindIdOrPwd();
                break;
            default:
                System.out.println("please choose 1~3 menu...");
            }
        }//while.

    }//main

    private void InstaFindIdOrPwd() {
        System.out.println("Find your Id , Password...");
        System.out.print("Please Enter Your Sign-Up Email >> ");
        String email = scanner.nextLine();
        Instagram findIdOrPwd = dao.read(email);
        
        if(findIdOrPwd != null) {
            System.out.println("your register Info >> ");
            System.out.println(findIdOrPwd);
        } else {
            System.out.println("Wrong Email...");
        }
    }//end of InstaFindIdOrPwd

    private void InstaSignUp() {
        System.out.println("Instagram Sign-Up...");
        System.out.print("Enter ID >> ");
        String id = scanner.nextLine();
        System.out.print("Enter Password >> ");
        String password = scanner.nextLine();
        System.out.print("Enter E-Mail >> ");
        String email = scanner.nextLine();
        System.out.print("Enter Phone Number >> ");
        String phone = scanner.nextLine();
        System.out.print("Enter User Name >> ");
        String name = scanner.nextLine();
        
        int result = dao.create(id, password, email, phone, name);
        
        if(result==1) {
            System.out.println(">> HELLO "+id+" Wellcome to Instagram :)");
        } else {
            System.out.println(">> Sorry please Again Sign-Up...");
        }
    }//end InstaSignUp...

    private int showMainMenu() {
        int menu = 0;
        System.out.println("Welcome to Instagram v0.2");
        System.out.println("1. Sign Up");
        System.out.println("2. Log in");
        System.out.println("3. Search Register Info");
        System.out.println("0. Exit Instagram v0.2");
        System.out.print("Enter the Menu...>> ");
        menu = Integer.parseInt(scanner.nextLine());

        return menu;
    }//end showMainMenu...

}//end class
