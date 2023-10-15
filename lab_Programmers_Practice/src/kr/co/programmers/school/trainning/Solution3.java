package kr.co.programmers.school.trainning;

import java.util.Scanner;

public class Solution3 {

    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
     Solution3 s = new Solution3();
     System.out.print("Enter my_string >> ");
     String a = scanner.nextLine();
     System.out.print("Enter overwirte_string >> ");
     String b =scanner.nextLine();
     System.out.print("Enter int s >> ");
     int number = Integer.parseInt(scanner.nextLine());
     
     s.solution(a, b, number);
        
        
    }

    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        
        for(int i = 0; i<s; i++) {
            answer += my_string.charAt(i);
        }
        
        System.out.println(answer);
        
        int j = 0;
        while(j < overwrite_string.length()) {
            answer += overwrite_string.charAt(j);
            j++;
        }
        
        System.out.println(answer);
        
        int k = s+j;
        while(k < my_string.length()) {
            answer += my_string.charAt(k);
            k++;
        }
        
        System.out.print(answer);
        
        return answer;
        
    }
    
    
}
