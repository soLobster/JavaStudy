package com.itwill.loop02;

public class LoopMain02 {

    public static void main(String[] args) {
        // 0,2,4,6,8,10 출력결과
        
        for(int i=0; i<=5; i++) {
                System.out.print(i*2+" ");
            }
        
        System.out.println();
        
        System.out.println("==================");
        
        for(int i=0; i<=10; i += 2) {
                System.out.print(i+" ");
            }
        
        System.out.println();
        
        System.out.println("==================");
        
        for(int i=0; i<=10; i++) {
                if(i % 2 ==0) {
                    System.out.print(i+" ");
                } 
            }
        
        }

}
