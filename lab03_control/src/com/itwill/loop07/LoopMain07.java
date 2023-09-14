package com.itwill.loop07;

public class LoopMain07 {

    public static void main(String[] args) {
        // 구구단 출력.
        // 2단은 2*2, 3단은 3*3, 4단은 4*4, 5단은 5*5......
        
            for(int i=2; i<=9; i++) {
                System.out.println(i+"단===================");
                System.out.println();
                    for(int j=1; j<=9; j++) {
                        System.out.printf("%d X %d = %d\n",i,j,i*j);
                        
                        if(j==i) {
                            break;
                        }    
                    }
                System.out.println();
            }
            
            System.out.println("--------------------------");
            System.out.println();
            
            for(int i=2; i<=9; i++) {
                System.out.println(i+"단===================");
                System.out.println();
                    for(int j=1; j<=i; j++) {
                        System.out.printf("%d X %d = %d\n",i,j,i*j);
                    }
                System.out.println();
            }
            
    }
}
