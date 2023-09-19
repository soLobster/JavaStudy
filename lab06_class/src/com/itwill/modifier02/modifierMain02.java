package com.itwill.modifier02;

import com.itwill.modifier01.AccessTest;
//다른 패키지에서 선언된 클래스 이름으로 변수를 선언하거나 사용하려고 할 때 import문을 쓴다.....
//1) import 문장을 작성하고, 클래스 이름만 사용.
//2) package 이름을 포함한 클래스 전체 이름을 사용할 수도 있다. -> 이 경우 import 문장이 필요 없다.
//3) import문 없이 사용가능한 패키지
//   java.lang 패키지 -> import문장 없이 클래스 이름을 사용할 수 있다....ex) java.lang.String, java.lang.System, java.lang.Math,....
//   모든 자바 프로그램을 위한 기본 패키지....JDK가 가지고 있는 패키지이다.
public class modifierMain02 {

    public static void main(String[] args) {
        // AccessTest 타입 객체 생성...
        
        
        AccessTest test = new AccessTest(3, 3, 3, 3); // 주석 1)의 사용법...
        com.itwill.modifier01.AccessTest act = new com.itwill.modifier01.AccessTest(2, 4, 6, 8); // 주석 2)의 사용법....
        //사용 사례가 거의 없다.....
        //import를 할때 다른 패키지에서 같은 이름의 클래스가 있을때 보통 하나만 임포트를 하고 하나는 주석 2)와 같이 사용한다.       
        //System.out.println(test.c); -> 컴파일 에러 : 보이지 않음(not visible).
        test.d = 100; //다른 패키지에 있는 클래스에서는 public으로 공개된 멤버만 사용 가능.
        test.info(); // <- public으로 공개되어 있는 메서드임.
        System.out.println();
        act.info();

    }

}
