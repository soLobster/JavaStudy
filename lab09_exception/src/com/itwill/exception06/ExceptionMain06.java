package com.itwill.exception06;

/*
 * 예외 클래스들의 상속 관계 -> 
 * object
 * \____throwable
 *       |_______Exception
 *               |________RuntimeException, IOException,.....
 *                        |__________ArithmeticException, NullPointerException, NumberFormatException.....
 *                        
 * throws 선언문이 있는 메서드들 중에서 RuntimeException과 하위 예외 클래스들을 던지는(throw) 
 * 메서드들은 try-catch를 사용하지 않아도 컴파일 가능.
 * RuntimeException이 아닌 예외를 던진다고 선언한 메서드들은 반드시 try-catch를 써야만 한다...
 * 
 */


public class ExceptionMain06 {

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        // Calculator 타입 객체의 메서드 호출....
        try {
            int result = calc.divide(100, 0);
            System.out.println("몫="+result);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
