package kr.co.programmers.school.trainning;

import java.util.Scanner;

public class Solutioin1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter String >> ");
        String a = scanner.next();

        String result ="";
        for(int i =0; i < a.length(); i++) {
            char c = a.charAt(i);
            if(Character.isUpperCase(c)) {
                result += Character.toLowerCase(c);
            } else {
                result += Character.toUpperCase(c);
            }
        }
        System.out.println(result);
    }

}