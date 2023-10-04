package com.itwill.exception02;

import java.util.Scanner;

/*
 * try-catch 문장을 사용한 예외처리...
 * try {
 *      정상적인 상황에서 실행할 코드(블럭); (1)
 * } catch (Exception 타입의 변수를 하나 선언). {
 *  예외가 발생했을때 실행할 코드(블록); (2)
 * } finally {예외 발생 여부와 상관없이 반드시 실행할 코드.} (3)
 * 
 * 예외가 발생하지 않을 경우 -> 1) -> 3) 실행
 * 예외가 발생하는 경우 -> 1) --> 예외발생 -->  2) --> 3) 
 * 
 * try-catch 문장에서 catch블록은 1개 이상이 있어야함.
 * finally 블록은 선택...
 * catch 블록은 처리하려고 하는 예외 종류에 따라서 여러개를 작성할 수 있음...
 * catch 블록이 여러개일 때는 하위타입의 예외들을 먼저 catch하고,
 * 상위 타입의 예외들을 나중에 catch해야 함. 
 * ex) Arithmetic -> NumberFormat -> Exception 
 * 
 */

public class ExceptionMain02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("X = ");
            int x = Integer.parseInt(sc.nextLine());

            System.out.print("Y = ");
            int y = Integer.parseInt(sc.nextLine());

            int result = x/y;
            System.out.println("몫 = "+result);
        } catch (ArithmeticException e) { //그냥 Exception 타입으로 몽땅 다 예외 처리해도 괜찮다.  //에러를 잡아내는 수비수라 생각해라...
            System.out.println("Y는 0이 될 수 없습니다.");
        } catch (NumberFormatException e) { //try-catch (catch는 하나 이상)
            System.out.println("X/Y는 정수로만 입력해야합니다.");
        } finally { //finally는 에러가 있든 없든 마지막에 무조건 실행됨.... 프로그램이 비정상적으로 끝나도 finally가 실행됨....
            System.out.println("FINALLY.....");
        }
    }
}
