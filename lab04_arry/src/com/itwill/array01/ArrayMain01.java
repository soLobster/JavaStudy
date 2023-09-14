package com.itwill.array01;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class ArrayMain01 {

    public static void main(String[] args) {
        /*배열의 필요성.
         * 
        */

        int score1 = 100;
        int score2 = 90;
        //int score3 = 85;
        
        int total = score1+score2;
        
        double mean =(double) total/2.0;
        
        // 배열(array): 같은 타입의 데이터 여러개를 하나의 변수 이름으로 저장하기 위한 메모리.
        // 인덱스(index): 배열에 데이터를 저장하거나, 저장된 값을 읽어올 때 사용하는 정수.
        // -> 배열에 데이터가 저장된 위치.
        // -> 인덱스는 0부터 시작하는 연속된 정수.
        // -> 마지막 인덱스는 (배열 원소개수 -1)
        
        // 배열 선언&초기화 방법(1):
        // 타입[] 이름 = new 타입[]
        
        int[] scores = new int[4];
        
        // 배열의 특정위치에 값을 저장:
        // 배열[인덱스] = 값;
        scores[0] = 100;
        scores[1] = 90;
        scores[2] = 87;
        scores[3] = 90;
        
        //배열에 저장된 값을 읽을 때: 배열[인덱스]
        //배열의 길이 원소 갯수.
        for(int i = 0; i<scores.length; i++) {
            System.out.printf("scores[%d] = %d\n", i, scores[i]);
        }
        
        
        System.out.println("==========================================");
        
        // 배열 선언&초기화 방법(2):
        // 배열이 가지고 있는 원소들을 나열하면서 배열을 초기화 하는 방법.
        // 타입[] 이름 = {1,2,3....};
        int[] num = {1,2,3,4,5};
        
        for(int i = 0; i<num.length; i++) {
            System.out.printf("num[%d] = %d\n", i, num[i]);
        }
        
        System.out.println("==========================================");
        
        //향상된 for문 (enhanced for)
        //for-each 구문...
        //for(변수 선언: 배열) {....}
        //배열의 원소들을 처음부터 끝까지 순서대로 꺼내면서 반복 블록을 실행.
        for(int i : num) {
            System.out.printf("num[%d] = %d\n", i-1 ,num[i-1]);
        }
        
        
        // 문자열 배열.
        // 문자열들을 여러가지 저장.
        String[] names = new String[3];
        // 문자열 배열의 특정 위치(인덱스)에 문자열들을 저장.
        names[0] = "kwon";
        names[2] = "jung";
        //1)인덱스

        for(int i = 0; i<names.length; i++) {
            System.out.println(names[i]);
        }
        for(String s : names) {
            System.out.println("\"향상된 for문 "+s+"\"");
        }
    }

}
