package com.itwill.loop06;

public class LoopMain06 {

    public static void main(String[] args) {
        // 이중 반복문 (중첩 반복문) for
        
        for(int i=2; i<=9; i++) {
            System.out.println(i+"단===================");
            System.out.println();
                for(int j=1; j<=9; j++) {
                    System.out.printf("%d X %d = %d\n",i,j,i*j);
                }
                System.out.println();
        }

    }

}
