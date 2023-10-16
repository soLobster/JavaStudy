package kr.co.programmers.school.trainning;

import java.util.Map;
import java.util.Scanner;

public class Solution7 {

    public static void main(String[] args) {

        Solution7 s7 = new Solution7();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Num >> ");
        String a = sc.nextLine();
        s7.solution(a);
        
        
    }

    public int solution(String number) {
    int answer = 0;
//        int sum = 0;
//        String[] num_list = number.split("");
//        for(int i=0; i<num_list.length; i++) {
//            sum += Integer.parseInt(num_list[i]);
//        }
//        answer = sum%9;
        System.out.println(number);
        return answer;
    }
}
