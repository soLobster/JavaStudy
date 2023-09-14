package com.itwill.loop09;

public class LoopMain09 {

    public static void main(String[] args) {
        // 중첩 while문. 구구단. 2단-9단.
        
        int i=2;
        int j=0;
        while(i<10){
            System.out.println(i+"단");
            j = 1; // j의 값을 초기화를 해줘야한다. 
            while(j<10) { 
                System.out.printf("%d X %d = %d\n",i,j,i*j);
                j++;
            } 
            i++;
        }

    }
}
