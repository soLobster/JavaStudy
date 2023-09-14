package com.itwill.print;

public class PrintMain {

    public static void main(String[] args) {
        // 메인 메서드 - 프로그램 시작.
        System.out.println("한 줄 출력");//print line
        System.out.println("1+2"); //문자열 String ""
        System.out.println(1+2); 
        
    
        System.out.println("1 + 2 = " + (1+2)); // 1+2 = 3
        System.out.println("1 + 2 = " + 1+2); // 1+2 = 12
        System.out.println("1 + 2 = 3");
        
        System.out.print("Hello\n");
        System.out.print("안녕");
        System.out.println("Java");
        
        System.out.printf("%d + %d = %d", 10, 10, 10+10).println(); //print format
        System.out.printf("문자열 포맷: %d, %f, %s\n", 10,10.0,"10");//정수 digit, 실수 floating-point number, 문자열 string
        System.out.printf("%d + %d = %d", 1, 2, 1+2).println();
        System.out.printf("%d + %d = %d\n", 1, 2, 1+2);
    }
    
}
