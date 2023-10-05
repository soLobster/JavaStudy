package com.itwill.set03;

import java.util.HashSet;
import java.util.Random;

public class SetMain03 {

    public static void main(String[] args) {
        // 정수를 저장하는 HashSet<E>
        HashSet<Integer> num = new HashSet<Integer>();
        //0~10 난수 생성, 서로 다른 정수 5개를 set에 저장.
        Random random = new Random(); 
        while(num.size()!=5) {
            num.add(random.nextInt(10));
        }
        System.out.println(num);
    } //end main
}//end class