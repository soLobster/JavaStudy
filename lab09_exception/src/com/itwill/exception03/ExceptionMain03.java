package com.itwill.exception03;

import java.util.Scanner;

public class ExceptionMain03 {

    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ExceptionMain03 app = new ExceptionMain03();

        int x = app.inputInteger();
        System.out.println("int x = "+x);
    }//end of main

    public int inputInteger() {
        int inputNum=0;
        boolean run = true;
        while(run) {
            try{
                System.out.println("정수를 입력하세요.");
                System.out.print(">> ");
                inputNum = Integer.parseInt(sc.nextLine());
                run = false;
            } catch (Exception e) {
                System.out.println("정수만 입력해주세요");
            }
        }//end while
        return inputNum;
    }//end inputInteger method...

}//end of class