package com.itwill.array05;



/*
 * 2차원 배열 (다차원 배열) : 1차원 배열들을 원소로 갖는 배열.
 * 다차원 배열 : 배열들을 원소로 갖는 배열.
 * 2차원 배열은 인덱스를 2개 갖는다.
 * 2차원 배열 선언 및 초기화 방법 1:
 * 타입[][] 배열이름 = { {.....},{.....} };
 */

public class ArrayMain05 {

    public static void main(String[] args) {
        int[][] array = {
                {1,2,3},
                {5,6,7,8},
                {9,10,11,12,13}
        };

        // 배열의 길이 = 3
                System.out.println("twoArray length >> "+array.length);
                // Array[0]의 타입은 int[].
                // Array[0]의 길이? 
                System.out.println("twoArray[0] length >> "+array[0].length);
                System.out.println("twoArray[0][0] >> "+array[0][0]); //int타입
                System.out.println("twoArray[1] length >> "+array[1].length);
                System.out.println("twoArray[2] length >> "+array[2].length);

                // 배열 array의 내용을 출력.

                for(int i=0; i<array.length; i++) {
                    for(int j=0; j<array[i].length; j++) {
                        System.out.print(array[i][j]+"\t");
                    }
                    System.out.println();
                }
                System.out.println("===============================");
                //향상된 FOR문
                for(int[] arr: array) { //int[] arr: array에 1차원 배열을 따온다.
                    for(int x : arr) {  //int[] arr에서 x(원소) 를 따온다.
                        System.out.print(x+"\t");
                    }
                    System.out.println();
                }

    }
}

