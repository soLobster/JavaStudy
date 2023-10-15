package kr.co.programmers.school.trainning;

import java.util.Scanner;

public class Solution4 {

    
    
    public static void main(String[] args) {
       Solution4 s = new Solution4();
       Scanner scanner = new Scanner(System.in);
       
       System.out.print("Enter my_string >> ");
       String a = scanner.nextLine();
       System.out.print("Enter overwirte_string >> ");
       String b =scanner.nextLine();
       System.out.print("Enter int s >> ");
       int number = Integer.parseInt(scanner.nextLine());
       
       s.solution(a, b, number);

    }

    public String solution(String my_string, String overwrite_string, int s) {
        String before = my_string.substring(0, s); // 입력된 s 미만의 인덱스까지 불러옴 0,1 
        System.out.println(before); //subString을 통해 뽑아진 before 문자열.
        String after = my_string.substring(s + overwrite_string.length()); // 입력된 s와 입력된 overwrite_string의 문자열 크기를 합친 인덱스 다음 문자열을 불러옴.
        System.out.println(overwrite_string.length());
        System.out.println(after);
        System.out.println(before + overwrite_string + after);
        return before + overwrite_string + after;
    }
    
}
