package com.itwill.loop01;

public class LoopMain01 {

    public static void main(String[] args) {
       
        
        for(int i=5; i>=1; i--) {
            System.out.println(i);
        }
        
        System.out.println("==================");
        
        for(int i = 1; i<=5; i++) {
            for(int j = 1; j<=i; j++) {
                System.out.print("X");
            }
            System.out.println();
        }
        for(int k = 1; k<=4; k++) {
            for(int l = 1; l<=4-k+1; l++) {
                System.out.print("X");
            }
            System.out.println();
        }
        System.out.println("==================");
        
        for(int i=1; i<=5; i++) {
            for(int j=1; j<5-i+1; j++) {
                System.out.print("O");
            }
            for(int k=1; k<=(2*i)-1; k++) {
                System.out.print("X");
            }
            System.out.println();
        }
        for(int l=4; l>0; l--) {
            for(int m=5-l; m>0; m--) {
                System.out.print("O");
            }
            for(int n=(l*2)-1; n>0; n--) {
                System.out.print("X");
            }
            System.out.println();
        }
            
    }
               
}

