package com.itwill.loop10;

public class LoopMain10 {

    public static void main(String[] args) {
        int i;
        int j;
        // while:
        //  문장은 반복 블록을 시작하기 전에 조건식을 검사하기 때문에,
        // 실행 블록이 한 번도 실행되지 않는 경우가 있을 수 있음.

        i = 1;
        while(i<=5) {
            System.out.println(i+": while!");
            i++;
        }
        System.out.println("end of while");
        
        System.out.println("------------------------");
        // do-while 문
        // 무조건 실행 블록을 먼저 실행하고 난 후 
        // 반복을 계속할 지를 검사를 한다.
        j = 5;
        do {
            System.out.println(j+": do-while!!");
            j--;
        } while(j>0);
        System.out.println("end of do-while");
    }

}
