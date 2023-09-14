package com.itwill.method02;

import java.util.Scanner;

// 메서드 작성 연습.....
// 리턴 타입과 아규먼트를 갖는 메서드 작성, 호출 연습.
public class MethodMain02 {    
    public static void main(String[] args) {
        //다른 메서드 안에서 또 다른 메서드 생성 불가.

        //같은 클래스의 메서드를 호출할 때는 메서드 이름으로만 호출할 수 있음.
        Scanner sc = new Scanner(System.in);
        System.out.print("X 값을 입력하세요. >> ");
        int inputX = Integer.parseInt(sc.nextLine());
        System.out.print("Y 값을 입력하세요. >> ");
        int inputY = Integer.parseInt(sc.nextLine());
        
       double resultAdd = add(inputX, inputY);
       double resultSub = subtract(resultAdd, 5);
       
       System.out.println("add: "+resultAdd);
       System.out.println("subtract: "+resultSub);
       
       double resultMul = multiply(resultAdd, resultSub);
       double resultDiv = divide(resultMul, resultAdd);
       
       System.out.println("multiply: "+resultMul);
       System.out.println("divide: "+resultDiv);
       sc.close();
    }
    /**
     * 숫자 2개를 전달받아서, 두 숫자의 덧셈 결과를 반환하는 메서드.
     * @param x double 타입
     * @param y double 타입
     * @return x + y.
     */
    
    public static double add(double x, double y) {
        return x+y;
    } // end add.
    
    /**
     * 숫자 2개를 전달 받아서, 첫번째 아규먼트에서 두번째 아규먼트를 뺀 결과를 리턴.
     * @param x double.
     * @param y double.
     * @return x - y.
     */
    public static double subtract(double x, double y) {
        return x-y;
    } // end subtract.
    
    /**
     * multiply.
     * 숫자 2개를 전달 받아서, 첫번째 아규먼트와 두번째 아규먼트를 곱을 리턴.
     * @param x double.
     * @param y double.
     * @return x * y.
     */
    public static double multiply(double x, double y) {
        return x*y;
    } // end multiply
    
    /**
     * divide.
     * 숫자 2개를 전달 받아서, 첫번째 아규먼트와 두번째 아규먼트의 나눈 결과를 리턴.
     * @param x double.
     * @param y double.
     * @return x/y.
     */
    
    public static double divide(double x, double y) {
        return x/y;
    } // end divide.
    
} // end class.
