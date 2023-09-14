package com.itwill.array03;

import java.util.Random;

// 향상된 FOR 구문은 배열에 있는 원소 값을 가져오는 것.
// 배열에 저장된 값들을 순서대로 읽는 경우에만 사용.
// 임시 변수에 저장하는 놈, 원소를 저장/변경할 때 이용할 수 없음.
// 원소를 저장과 변경하려면 "배열 [인덱스]" 이용해야한다.

public class ArrayMain03 {

    public static void main(String[] args) {
        
        Random random = new Random();
        int[] arr = new int[3];
        for(int i=0; i<arr.length; i++) {
            arr[i] = random.nextInt(10);
            System.out.printf("arr[%d] = %d\n",i,arr[i]);
        }
        
        /* ---->향상된 for문 배열 저장 안됨
        for(int x : arr) {
            arr[x] = random.nextInt(10);
            System.out.print(arr[x]+"  ");
        }
        System.out.println();
        */
        
        for(int x : arr) {
            System.out.print(x + "  ");
        }
        System.out.println();
        System.out.println("=========================================================");
        // 1) ex. 정수 10개를 저장할 수 있는 배열을 만들고,
        // 2) 1이상 4이하 의 정수들을 임의로 저장하세요. 그 내용을 출력.
        // 3) 문자열 10개를 저장할 수 있는 배열을 만들고,
        // 4) 1)에서 만든 배열의 원소가 1 또는 3이면 "male" 2또는 4이면 "female" 을 저장.
        // 5) 문자열 배열 내용을 출력.
        int len = 10; // 배열의 길이(원소 개수)로 사용할 변수.
        
        int[] human = new int[len];   // new int[10] = new int[len]
        for(int i=0; i<len; i++) { //humanlength => len 
            human[i] = random.nextInt(1,5);
        }
        for(int x : human) {
            System.out.print(x+"\t");
        }
        
        String[] gender = new String[len];
        for(int j=0; j<len; j++) {
            if(human[j]==1||human[j]==3) {
                gender[j] = "M";
            } else {
                gender[j] = "F";
            }
        }
        System.out.println();    
        for(String x : gender) {
            System.out.print(x+"\t");
        }
        
    }
}
