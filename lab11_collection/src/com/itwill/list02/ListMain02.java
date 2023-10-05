package com.itwill.list02;

import java.util.LinkedList;
import java.util.Random;

public class ListMain02 {

    public static void main(String[] args) {
        Random random = new Random();
        //1.정수를 저장하는 LinkedList 변수(numbers) 선언, 객체 선언
        LinkedList<Integer> numbers = new LinkedList<Integer>();
        //2.numbers에 정수 (난수 범위 0이상 100미만) 20개를 저장.
        for(int i=0; i<20; i++) {
            numbers.add(random.nextInt(100));
        }
        //3.numbers를 출력..
        System.out.println(numbers);
        System.out.println();
        //4.홀수들을 저장하는 LinkedLisdt 변수 (odds) 선언, 객체 생성.
        LinkedList<Integer> odds = new LinkedList<Integer>();
        //5.odds에는 numbers에 있는 정수 중에서 홀수들만 odds에 저장.
        for(int i=0; i<numbers.size(); i++) {
            if(numbers.get(i)%2 != 0) {
                odds.add(numbers.get(i));
            }
        }
        //6.odds를 출력
        System.out.println(odds);
    }//end of main...

}//end of class...
