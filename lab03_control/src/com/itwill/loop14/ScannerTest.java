package com.itwill.loop14;
import java.util.Scanner;

public class ScannerTest {

    public static void main(String[] args) {
        // Scanner 타입을 사용한 입력 받기:
        
        Scanner scanner = new Scanner(System.in);
        
        /* nextInt(): 입력버퍼(임시메모리)에서 토큰으로 구분된 입력 값을 읽어서 
         * 정수(int)를 반환해준다.
         * [토큰(Token) : 공백문자(Spacebar, Tab, Enter 등)로 구분되는 요소.]
         * nextDouble(): 실수(double) 타입을 반환해준다.
         * next(): 문자열을(String) 반환해준다.
         * nextInt(), nextDouble(),next(): 값을 읽은 후에도 입력 버퍼(임시 메모리) 남아있는 내용이 있을 수 있음.
         */
        
        
        System.out.print("정수 입력 >> ");
        int n1 = scanner.nextInt(); //공백(space)으로 숫자 구분 가능.
        System.out.println("n1 = "+n1); //입력버퍼(메모리) 공백,tab,엔터.
        
        System.out.print("정수 입력 >> ");
        int n2 = scanner.nextInt();
        System.out.println("n2 = "+n2);
        
        System.out.print("문자열을 입력하세요 >> ");
        String s = scanner.next(); //공백이 있는 문자열을 다 읽을 수 없다. 
        //String s1 = scanner.nextLine(); //입력버퍼에서 enter를 만날 때까지 모든 값을 읽어서 문자열을 리턴한다.
        // nextLine() 이후에는 입력버퍼의 모든 내용이 지워진다. [엔터단위로 입력을 받는다!!!]
        // 나머지 단위들은 토큰단위로 입력 받음.
        System.out.println("s = "+s);
        //System.out.println("s1 = "+s1);
        
        scanner.nextLine(); //입력버퍼에 남아있는 모든 내용을 읽고 지워버린다. 해결책!!....
        
        System.out.print("문자열 입력 >> ");
        String msg = scanner.nextLine(); //엔터가 포함되기 때문에 콘솔 결과가 꼬이게 된다.
        // next 토큰을 만날때 까지....읽은것 까지를 지워야한다. 
        // 앞으로는 무조건 nextLine()으로 입력을 받아 정수면 정수 실수면 실수로 변환할 것이다.
        // 버퍼를 깨끗하게 지워버리기 때문. 
        System.out.println("msg = "+msg);
        
        
        
        System.out.print("실수 입력 >> ");
        double n3 = scanner.nextDouble();
        System.out.println("n3 = "+n3);
        
    }

}
