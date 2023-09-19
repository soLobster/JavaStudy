package com.itwill.modifier01;

/**
 * 클래스 멤버(필드, 생성자, 메서드)의 접근(가시성) 수식어 (access modifier) 
 * - 클래스의 멤버들을 보여주는 범위를 설정.
 * 가시성의 범위: private < {(package)수식어가 없는 경우} < protected < public.
 *              //클래스 자체는 package와 public 밖에 없다...
 * 1. private: 필드,생성자, 메서드에 붙일 수 있다. 선언된 클래스 안에서만 보이는(직접 접근 가능한) 멤버...
 * 2. (package) 수식어가 없는 경우. 같은 패키지에 있는 클래서에서 보이는 (사용 가능한) 멤버...
 *     ex) 필드에 선언된 것들....
 * 3. protected 같은 패키지에 있거나 또는 상속하는 클래스에서 보이는(사용 가능한) 멤버.
 * 4. public 어디서든 보이는 (사용 가능한) 멤버
 * 
 * -> 데이터 캡슐화.....!
 * 
 */

public class modifierMain01 {

    public static void main(String[] args) {
        AccessTest act = new AccessTest(1, 2, 3, 4);
        //System.out.println(act.a); -> 컴파일 에러 not visible....
        System.out.println(act.b);
        act.b = 100;
        System.out.println(act.c);
        act.c = 101;
        System.out.println(act.d);
        act.d = 102;
        act.info(); //퍼블릭으로 공개되어 있는 메서드를 통해 간접적으로 접근 가능!

    }

}
