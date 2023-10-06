package com.itwill.set03;

import java.util.HashSet;
import java.util.Random;

public class SetMain03 {

    public static void main(String[] args) {
        // 정수를 저장하는 HashSet<E>
        HashSet<Integer> num1 = new HashSet<Integer>();
        //0~10 난수 생성, 서로 다른 정수 5개를 set에 저장.
        Random random = new Random(); 
        int count1 = 0;
        while(num1.size()!=5) {
            num1.add(random.nextInt(10));
            count1 ++;
        }
        System.out.println(num1);
        System.out.println("count = "+count1);

        boolean run = true;
        HashSet<Integer> num2 = new HashSet<Integer>();
        int count2 = 0;
        while(run) {
            if(num2.size() != 5) {
                num2.add(random.nextInt(10));
                count2 ++;
            } else if(num2.size() == 5) {
                run = false;
                //break;
            }
        }
        System.out.println(num2);
        System.out.println("count = "+count2);
    } //end main
}//end class