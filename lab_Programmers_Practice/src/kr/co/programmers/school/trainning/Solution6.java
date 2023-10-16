package kr.co.programmers.school.trainning;

import java.util.Scanner;

public class Solution6 {

    public static void main(String[] args) {
        Solution6 s6 = new Solution6();
        Scanner sc = new Scanner(System.in);
        System.out.print("Type String >> ");
        String my_string = sc.nextLine();
        System.out.print("Type repeat time >> ");
        int k = Integer.parseInt(sc.nextLine());
        
        s6.solution(my_string, k);

    }

    public String solution(String my_string, int k) {
        String answer = "";
        for(int i = 0; i<k; i++) {
            answer += my_string;
        }
        System.out.println(answer);
        return answer;
    }

}
