package com.itwill.inner01;

import java.util.Random;
//내부 클래스  이름을 임포트...
import com.itwill.inner01.Outer.Inner;
import com.itwill.inner01.Enclosing.Nested;

/*
 * 내부 클래스, 내부 인터페이스.
 * 
 * 변수 선언 위치.
 * 1. 필드: 클래스의 멤버로 선언하는 변수. 접근 수식어(private, public, ....)를 사용할 수 있음.
 *  - 인스턴스 필드 : static이 아닌 필드.
 *      - 객체를 생성한 후에, 그 참조변수로 접근해서 사용하는 필드.
 *      - 객체 생성자 호출할때 메모리에 만들어짐.
 *      
 *  - 클래스 필드 : static으로 선언된 필드.
 *      - static이 붙어있음 
 *      - 프로그램이 시작될 때 class loader에 의해서 메모리에 미리 로딩되는 변수.
 *      - 객체를 생성하지 않고, 클래스 이름을 접두사로 사용함.
 *      
 * 2. 지역 변수: 메서드 안에서 선언하는 변수. 접근 수식어를 사용할 수 없음.
 *  - 선언된 위치에서부터 변수가 포함된 블록이 끝날 때까지 사용 가능.
 *  - 파라미터도 지역변수의 한 종류.
 *  - 지역변수는 static을 사용할 수 없음.
 *  
 *  외부클래스/인터페이스(outer, enclosing class/interface)
 *     내부 클래스/인터페이스를 감싸고 있는 클래스/인터페이스.
 *  내부클래스/인터페이스(inner class/interface)
 *     다른 클래스/인터페이스 안에서 선언된 클래스/인터페이스
 *  
 *  1. 멤버 내부 클래스
 *      1) 인스턴스 내부 클래스.
 *          - 외부 클래스의 객체를 먼저 생성한 후에,
 *          그 참조 변수를 사용해서 객체를 생성(생성자 호출)할 수 있는 내부 클래스.
 *          
 *      2) static 내부 클래스. static으로 선언된 내부 클래스.
 *          - 외부 클래스의 객체 생성 여부와 상관 없이 사용할 수 있는 클래스.
 *          - 중첩 클래스(nested class).
 *  2. 지역 내부 클래스(local class) : 메서드 안에서 선언된 내부 클래스.
 *       - 선언된 메서드 블록 안에서만 객체를 생성하고 사용할 수 있는 클래스.
 *  3. 익명 내부 클래스(anonymous class) : 이름이 없는 내부 클래스. ★★★★★
 *       - 클래스 선언과 동시에 객체 생성까지 해야만 하는 클래스.
 *       -> 람다 표현식.
 */


public class InnerMain01 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Outer outer1 = new Outer(1, 2, "test");
        System.out.println(outer1);
        
        // outer.inner 클래스 타입 객체 생성.
        Outer.Inner inner1 = outer1.new Inner(10);
        inner1.info();
        
        Outer.Inner inner2 = outer1.new Inner(123);
        inner2.info();
        
        //System.out.println(inner1.getX()); 외부와 내부 클래스의 객체는 별개의 존재다. 상속과 내부 클래스의 다른 점.
        
        Outer outer2 = new Outer(0, 0, "점심시간");
        System.out.println(outer2);
        
        //import 문장이 있는 경우
        Outer.Inner inner3 = outer2.new Inner(24); 
        inner3.info();
        
        System.out.println("=====");
        //Enclosing 클래스의 static 멤버 사용. ClassName.member
        System.out.println(Enclosing.var);
        Enclosing.test();
        
        //Enclosing 타입 객체 생성
        Random random = new Random();
        Enclosing en = new Enclosing(random.nextInt(10));
        System.out.println(en); //en.toString
        
        //Enclosing.Nested 타입 객체 생성.
        Enclosing.Nested enNested = new Enclosing.Nested(123); //중첩 클래스.
        enNested.info();
        
        //import 문장이 있는 경우. 중첩인지 아닌지 알 수 가 없다.
        Nested nested2 = new Nested(222);
        nested2.info();
    }

}
