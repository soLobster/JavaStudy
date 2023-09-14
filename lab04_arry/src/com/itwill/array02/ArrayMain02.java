package com.itwill.array02;

import java.util.Random;

//시험 점수를 저장하는 배열에 점수들을 저장하고
// 배열의 내용을 출력. 총점 계산 출력, 평균 계산 출력.

//1. 정수(int) 10개를 저장할 수 있는 배열(scores)을 선언.
//2. for 구문을 이용. 배열 scores에 정수 10개를 저장.
//[0이상 10이하] 정수 난 수 저장.
//3. 배열에 저장된 점수들을 한줄에 출력.
//4. 배열의 모든 점수들의 합계를 계산하고 출력.
//5. 평균을 계산하고 출력.


public class ArrayMain02 {

    public static void main(String[] args) {
        
        Random random = new Random();
        
        int[] scores = new int[10];
        int sum = 0;
        double mean = 0;
        
        for(int i=0; i<scores.length; i++) {
                scores[i] = random.nextInt(11);
                System.out.print(scores[i]+" ");        
            }
        
        System.out.println();
        
        for(int x : scores) {
            sum += x;
            mean = (double) sum/scores.length;
        }
        
        System.out.println();
        
        System.out.println("SUM = "+sum);
        System.out.println("MEAN = "+mean);
    }

}
