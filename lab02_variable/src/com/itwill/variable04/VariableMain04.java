package com.itwill.variable04;

import javax.sound.midi.Soundbank;

public class VariableMain04 {

    public static void main(String[] args) {
        // 자바 기본 데이터 타입
        // 정수형 integer
        byte a = 127; //byte의 범위는 -128~127 정수만 저장 가능 1byte = 8bit 2^8
        short b = 32_767;//java 숫자단위 ',' 대신 '_' 언더스코어 (천단위) 
                        // short -32,768~32767 범위 정수만 저장 가능. 2^16 
        int c = 2_000_000_000; //int 2^32 
        //long d = 10_000_000_000; java의 특징 더 넓은 범위인데 저장할 수 없음. 
        // 자바는 4byte로 정수를 만드는 성질이 있다. long 범위가 크기 때문에 이를 초과한다.
        long d = 10_000_000_000L; 
        // 숫자 상수(literal)가 INT범위를 넘을 때는 숫자 뒤에 L을 붙여주면 8BYTE를 이용해 생성한다. 가능
        // 이유는 자바에서 정수의 기본 타입은 int이기 때문이다.
        
        // 자바에서 실수의 기본 타입은 double이다. (not float)
        double x = 1.0; //8byte double 타입 정수 상수(literal)를 만듦.
        float y = 1.0f; //4byte 더블타입이 아니다를 알려줘야한다. f를 붙여준다.
        
        //1.변수는 같은 타입의 값만 저장할 수 있음.
        //2.큰 범위의 타입에는 작은 범위 타입의 값을 저장 할 수 있음.
        //3.작은 범위 타입에 큰 범위의 값을 저장하려고 하면 에러.
        //4.정수 리터럴(상수)은 범위만 넘지 않으면 byte, short, char에 저장 가능.
        
        //char 타입: 문자 1개의 유니코드값을 저장하는 타입
        //자바는 문자열(String)은 큰따옴표, 문자(Character)는 작은 따옴표
        
        Character ch1 ='a';
        System.out.println(ch1);
        
        System.out.println((int) ch1);
        
        
        char ch2 = 98;
        System.out.println((char) ch2);
        
        short s1 = 10; //10은 int 리터럴. (범위만 넘지 않으면) byte, short, 또는 char 타입에 저장 가능.
        short s2 = 1;
        short s3 = (short) (s1+s2); // 변수 이름이나 연산식 앞에 타입을 적어준다 {강제타입변환 casting}
        // -> 변수 또는 변수가 포함된 연산식인 경우에는 작은 타입에 저장할 수 없음.
        // 강제 타입 변환(casting)을 하면 허용.
        System.out.println(s3);
        
        //char ch3 = (short) (s1+s2);
        char newChar = (char) (ch1+1);
        
        System.out.println(newChar);
        
        byte b1 = 127;
        byte b2 = 1;
        byte add1 = (byte) (b1 + b2);                    //CPU 기본 값 정수 int 실수 double.
        int add2 = b1 + b2;
        
        System.out.println(add1);
        System.out.println(add2);
     } 

}
