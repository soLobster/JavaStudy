package com.itwill.switch01;
import java.util.Scanner;
public class SwitchMain01 {

    public static void main(String[] args) {
        
        // switch-case 구문
        // 해당 case 위치로 이동해서 break; 문장을 만날 때까지 실행.
        // 해당 case가 없으면 default 블록을 실행.
        // default 블록은 switch 구문에서 항상 마지막에 작성.
        // switch (변수 또는 식)에서 사용할 수 있는 데이터 타입:
        // 1) 정수 - byte, short, int, long, char
        // 2) 문자열 - String
        // 3) enum
        // (주의) 실수 타입(float, double), boolean 타입 사용 불가.
        
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("계절을 영어로 입력하세요 >> ");
        String season = scanner.nextLine();
        switch (season) {
        case "spring": 
            System.out.println("봄");
            break;
        case "summer" :
            System.out.println("여름");
            break;
        case "fall":
            System.out.println("가을");
            break;
        case "winter":
            System.out.println("겨울");
            break;
            
        default:
            System.out.println("몰라요.");
            
        }
        
        System.out.print("숫자를 입려하세요 >> ");
        int number = scanner.nextInt();
        switch(number % 2) { //(number % 2 == 0) X 안된다.
        case 0:                 // case true X
            System.out.println("짝");
            break;
        case 1:                 // case false X
            System.out.println("홀");
            break;
        }
        
        scanner.close();
    }

}
