package com.itwill.method07;

import java.util.Scanner;

public class MethodMain07 {

    public static void main(String[] args) {
        // 가변길이인수(variable-length argument):
        // 메서드를 호출할 때 아규먼트의 개수가 정해져 있지 않은 경우.
        //ex System.out.printf();
        System.out.printf("%s는 %d살입니다.\n","mount",25);
        System.out.println();

        int sum = 0;

        sum = addAll(); //args가 0개. -> 0 리턴.
        System.out.println("sum :\t"+sum);

        sum = addAll(2); //args가 1개. -> 2 리턴.
        System.out.println("sum :\t"+sum);
        sum = addAll(1,2,3,4); //args가 4개. -> 10 리턴.
        System.out.println("sum :\t"+sum);

        System.out.println("==================================================");

        Scanner sc = new Scanner(System.in);
        int result;

        System.out.println();


        result = calculate("+",10,20);
        System.out.println("result : "+result);
        result = calculate("*",10,20);
        System.out.println("result : "+result);
        result = calculate("-",20,10);
        System.out.println("result : "+result);
        //        result = calculate("*", 10,5);
        //        System.out.println("multiply result : "+result);
        //        result = calculate("*", 60,5);
        //        System.out.println("multiply result : "+result);

    }//end main...

    /*
     *  가변 인수를 갖는 메서드를 선언하는 방법
     *  가변인수를 저장하는 파라미터는 "번수타입...변수이름" 형식으로 선언.
     *  가변인수는 메서드 안에서 배열처럼 취급.
     *  (주의1) 가변 인수를 저장하는 파라미터는 반드시 가장 마지막 파라미터여야 한다.
     *  (주의2) 가변 인수를 저장하는 파라미터는 2개 이상 있을 수 없다.
     *  가변인수를 갖는 메서드를 사용할 때는 전달하는 아규먼트 개수에 제한이 없음.
     *  - 가변 인수 위치에 아규먼트를 전달하지 않아도 됨.
     */

    /*
     * 아규먼트로 전달받은 모든 정수들을 다 더해서 리턴.
     * 아규먼트가 없는 경우에는 0을 리턴한다.
     * @param args 더해줄 정수들. 개수 제한 없음.
     * @return 0 또는 args들의 값.
     */
    public static int addAll(int... args) { //int[] args 와 int... args 구분 필수!...
        int sum = 0;                        //가변인수 args는 배열처럼 생각하자.
        for(int x : args) {
            sum += x;
        }

        return sum;
    }

    /**
     * 
     * argument op의 값이 "+" 인 경우, 가변 인수 values들의 합을 리턴.
     * argument op의 값이 "*" 인 경우, 가변 인수 values들의 곱을 리턴.\
     * argument op의 값이 "+" 나 "*"가 아닌 경우 0을 리턴....
     * 
     * @param op 연산자. "+" 또는 "*"
     * @param values 가변 인수. 정수(int)
     * @return values의 합 또는 곱을 리턴한다.
     * 
     */

    public static int calculate(String operation,int... args) {
        int operatorResult = 0;

        switch (operation) {
        case "+":
            for(int x : args) {
                operatorResult += x;
            }
            break;
        case "*":
            operatorResult = 1;
            for(int x : args) {
                operatorResult *= x;
            }
            break;
//        case "-":
//            operatorResult = 0;
//            for(int x : args) {
//                operatorResult -= x;
//            }
//            break;
//        case "/":
//            operatorResult = 1;
//            for(int x : args) {
//                operatorResult /= x;
//            }
//            break;
        default:
            System.out.println("연산자 값이 없네용...!");
            return 0;
        }


        //        if(op=="+") {
        //            for(int x : args) {
        //              operatorResult += x;
        //            }
        //        } else if(op=="*") {
        //            operatorResult = 1;
        //            for(int x : args) {
        //                operatorResult *= x;
        //            }
        //        } else if(op=="-") {
        //            operatorResult = 0;
        //            for(int x : args) {
        //                operatorResult -= x;
        //            }
        //        } else if(op=="/") {
        //            operatorResult = 1;
        //            for(int x : args) {
        //                operatorResult /= x;
        //            }
        //        }
        return operatorResult;
    }//end calculate...



}// end class...
