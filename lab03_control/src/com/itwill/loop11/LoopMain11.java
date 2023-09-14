package com.itwill.loop11;



public class LoopMain11 {

    public static void main(String[] args) {
        //1 부터 10 까지 자연수의 합.
        //sum = 1+2+3+4+....+10 = 55.
        int evenSum = 0;
        int oddSum = 0;
        /*
        for(int i=1; i<11;i++) {
            sum = sum+i;
            //System.out.println("sum: "+sum);
        }
        
        System.out.println("sum: "+sum);
        */
        
        //ex2. 1부터 ~100까지 자연수 중 짝수들의 합.
        //ex3. 1부터 ~100까지 자연수 중 홀수들의 합.
        System.out.println("==========for===============");
        for(int i=1; i<=100; i++) {
            if(i%2==0) {
                evenSum = evenSum+i;
            } else {
                oddSum = oddSum+i;
            }
        }
        System.out.println("evenSum: "+evenSum);
        System.out.println("oddSum: "+oddSum);
        
        System.out.println("==========while===============");
        
        int i=1;
        int sumEven = 0 ;
        int sumOdd = 0;
            while (i<=100) {
            
                    if(i%2==0) {
                        sumEven = sumEven + i;
                    } else {
                        sumOdd = sumOdd + i; 
                    }
                    
                i++;
            } 
            System.out.println("evenSum : "+ sumEven);
            System.out.println("oddSum : "+ sumOdd);
        }
}
