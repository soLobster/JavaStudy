package com.itwill.method08;



public class MethodMain08 {

    public static void main(String[] args) {
        // 재귀 메서드. (recursive method) 메서드 안에서 자기 자시을 다시 호출하는 메서드.
        int result = 0;
        for(long n = -1; n<=5; n++) {
           System.out.printf("%d! = %d\n",n,factorial(n));
       }
    }

    /**
     * 팩토리얼 계산 메서드.
     * 0! = 1. 
     * 1! = 1*1 = 1
     * 2! = 1*2 = 2
     * 3! = 1*2*3 = 6....
     * 일반적으로 n! = (n-1)! X n.
     * @param n 정수(long). 0 이상의 정수.
     * @return n이 0 이상의 정수이면 팩토리얼 계산값을 리턴. 음수이면 -1 을 리턴....
     */
    
    private static long factorial(long n) {
        long result = -1;
        if(n==0) { //0! = 1
            result = 1;
        } else if (n>0){
            result = factorial(n -1) * n; //n! = (n-1)! X n.
        } 
        return result;
    }
}
