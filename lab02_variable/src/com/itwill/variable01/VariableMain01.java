package com.itwill.variable01;

public class VariableMain01 {

    public static void main(String[] args) {
        // 변수(variable): 프로그램에서 필요한 데이터를 저장하는 메모리 공간.
        // 1.변수 선언: 변수의 데이터 타입과 이름을 선언.
        
        int age; // 정수를 저장하는 변수 AGE 선언
        
        // 2. 변수 초기화: 변수에 값을 처음으로 저장.
        // 변수 = 값;

        age = 10;
        
        System.out.println("아이의 나이는 "+age+"살 입니다.");
        
        // 변수 선언과 초기화를 한 문장으로 작성
        
        int x = 222;
        System.out.println("x = "+x);
        
        /* 자바의 기본 데이터 타입:
         * 정수 타입: byte 1, short 2, int 4, long 8, char 1
         * 실수 타입: float 4, double 8
         * 논리 타입: boolean 1
         * */
        
        // 변수 이름 작성 규칙: 
        // 알파벳, 숫자, '_', $ 만 사용 가능.
        // 변수 이름은 대/소문자를 구분한다. age, Age 
        // 변수 이름은 숫자로 시작할 수 없다. 1age, 2ge (X)
        // 변수 이름으로 자바의 키워드(예약어) 사용 금지. ex) int int = 1 (X) 
        // 변수 이름은 변수의 역할에 어울리는 "의미 있는" 단어를 사용해서 만드는 것을 권장한다.
        // 변수 이름을 2개 이상의 단어를 붙여서 만들 경우에는, 소문자로 시작하는 camelCase 표기법 사용(관습)
        // EX) age, number, userId, userPassword....
        
    }

}