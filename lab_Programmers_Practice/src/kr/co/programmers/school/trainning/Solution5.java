package kr.co.programmers.school.trainning;

import java.util.Scanner;

public class Solution5 {

    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      Solution5 s5 = new Solution5();
      
      System.out.print("Enter Word >> ");
      String words = scanner.nextLine();
      System.out.print("Enter Alphabet >> ");
      String alphabet = scanner.nextLine();
      
      s5.solution(words, alphabet);

      System.out.print("Enter Word >> ");
      String words2 = scanner.nextLine();
      System.out.print("Enter number >> ");
      int number = Integer.parseInt(scanner.nextLine());
      
      s5.solution1(words2, number);
      
    }//main

    public String solution1(String my_string , int n) {
        System.out.println(my_string.substring(my_string.length()-n));
        return my_string.substring(my_string.length()-n);
    }
    
    
    public String solution(String my_string, String alp) {
        String answer = "";
        answer = my_string.replace(alp, alp.toUpperCase());
        System.out.println(answer);
        return answer;
    }
    
    public String solution2(String str1, String str2) {
        String answer = "";
        for(int i = 0; i<str1.length(); i++) {
            answer += str1.substring(i,i+1);
            answer += str2.substring(i,i+1);
        }
        
        return answer;
    }
    
    
}//class
