package kr.co.programmers.school.trainning;

import java.util.Scanner;

public class Solution2 {

    public static void main(String[] args) {
        
       Scanner scanner = new Scanner(System.in);
       System.out.print("Enter >> ");
       String a = scanner.next();
      
       for(int i = 0; i<a.length(); i++) {
           System.out.println(a.charAt(i));
       }
       

    }

}
