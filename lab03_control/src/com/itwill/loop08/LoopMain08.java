package com.itwill.loop08;



public class LoopMain08 {

    public static void main(String[] args) {
        // while 반복문.
        
        int n = 9; // 시작값. 전역변수 while문 바깥.
        /* 
        int sum = 0;
        
        while(n < 5) {
            System.out.println("n:"+n);
            sum = sum + n;
            System.out.println("sum: "+sum);
            n++;
        }
        */
        System.out.println("---------[2]-----------");
        
        int i = 0;
        while(i > 0) {
            System.out.println("countDown: "+i);
            i--;
        }
        System.out.println("---------[3]----------");
        
        while(i < 11) {
            System.out.print(i+"\t");
            
            i=i+2; // i+=2;
        }
    
        System.out.println();
        
        n=0;
        while(n<=5) {
            System.out.print((2*n)+ " ");
            n++;
        }
        
        System.out.println();
        System.out.println("---------[4]----------");
        
        n = 9;
        while(n > 0) {
            System.out.print(n+"\t");
            //n2=n2-2;
            n-=2;
        }
        
        System.out.println();
        
        n = 9;
        while(n>0) {
            if(n%2==1) {
                System.out.println("OddNum: "+n);
            } else {
                System.out.println("EvenNum: "+n);
            }
            n--;
        }
        
        System.out.println("---------[5]----------");
        n=1;
        while(n<10) {
            System.out.printf("%d X %d = %d\n",9,n,9*n);
            n++;
        }
        System.out.println("-------------------");
        int x = 9;
        int y = 1;
        while(y<10) {
            System.out.println(x+" X "+y+" = "+(x*y));
            y++;
        }
        
        
    }
}
