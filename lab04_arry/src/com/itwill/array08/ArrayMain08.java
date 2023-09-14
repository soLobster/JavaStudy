package com.itwill.array08;

import java.util.Random;

/*
 * 1) 1차원 정수 배열 3개를 갖는 2차원 배열을 선언 및 초기화
 * 2) 첫번째 배열은 난수 2개, 두번째 배열은 난수 3개, 세번째 배열은 난수 4개.
 *      난수의 범위는 [0,10) 0이상 10미만.
 * 3) 2차원 배열의 원소들을 출력.
 * 4) 2차원 배열의 모든 원소들의 합을 계산하고 출력.
 * 5) 2차원 배열의 모든 원소들의 평균을 계산하고 출력. 
 */

public class ArrayMain08 {

    public static void main(String[] args) {
        int[][] arr = new int[3][];
        int sum = 0;
        int count = 0;
        double mean = 0;
        Random random = new Random();
        //arr[0] = new int[2];
        //arr[1] = new int[3];
        //arr[2] = new int[4];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[i + 2];
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = random.nextInt(10);
            }
        }

        for (int[] arrNum : arr) {
            for (int x : arrNum) {
                System.out.print(x + "\t");
                sum += x;
                count++;
            }
            System.out.println();
        }
            mean = (double) sum / count;
            System.out.println("sum:\t"+sum);
            System.out.println("mean:\t"+mean);
            
    }
}

