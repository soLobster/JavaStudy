package com.itwill.lambda01;

import com.itwill.lambda01.Calculator.Calculable;

public class LambdaMain01 {

    public static void main(String[] args) {

        // Calculator 타입의 객체 생성.
        Calculator calc = new Calculator(10, 2);

        //1. 외부 클래스 선언과 사용

        // Calculable 인터페이스를 구현하는 Adder 타입 객체를 생성. (외부 클래스)
        Calculable adder = new Adder();
        // 생성된 객체를 calculate 메서드의 아규먼트로 전달.
        double result = calc.calculate(adder);
        System.out.println("result = "+ result);

        //2. 지역 클래스 선언과 사용.(Subtractor)
        class Subtractor implements Calculable{
            @Override
            public double calculate(double x, double y) {
                return x-y;
            }

        }//class Subtractor
        result = calc.calculate(new Subtractor());
        System.out.println("result = "+ result);
        
        //3. 익명 클래스 선언과 사용.(Anonymous class)
        result = calc.calculate(new Calculable() {
            @Override
            //x multiple y
            public double calculate(double x, double y) {
                return x*y;
            }
        });
        System.out.println("result = "+result);
        
        //4.람다 표현식 (Lambda expression) - 함수형 표기법.
        result = calc.calculate((x,y) -> x/y);
        System.out.println("result = "+result);
    }//main

}
