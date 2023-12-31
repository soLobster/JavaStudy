package com.itwill.interface02;
/*
 * 인터페이스가 가질 수 있는 멤버들(종류)....Java 8 버전 이후의 변경 사항.
 * 1. [public static final](생략 가능...) 필드....
 * 2. [public abstract] 메서드 -> body가 없는 추상 메서드....구현 클래스에서 반드시 구현해야 함.
 * 3. [public] static 메서드 - Java 8 부터.
 *    -> 객체 생성 없이, 인터페이스 이름을 접두사로 써서 호출할 수 있는 메서드...
 * 4. [public] default 메서드 -> Java 8 부터....
 *    -> 바디가 구현된 메서드....인터페이스를 구현한 하위 타입의 객체를 생성한 후 호출할 수 있는 메서드....
 * 5. private static 메서드 출현 -> Java 9 부터...
 *    -> 바디가 구현된 메서드.... 
 *    -> static 또는 default 메서드에서만 호출할 목적으로 만드는 메서드....
 * 6. private 메서드... -> Java 9 부터....
 *    -> body가 구현된 메서드. 
 *    -> default 메서드에서만 호출할 목적으로 만드는 메서드....
 *    
 *    문법을 위해 만들어진...
 */

interface Test { //상수만 멤버로 가진다...
    //1. [public static final] 필드를 멤버로 가진다.
    int VERSION = 1;
    
    //2. [public abstract] 메서드
    void test();
    
    //3. [public] static 메서드
    static void staticMethod() {
        System.out.println("공개 스태틱 메서드");
    }; 
    
    //4. [public] default 메서드...
    default void defaultMethod() { //static이 아니라 호출 불가.
        System.out.println("공개 기본 메서드");
    }
    
    //5. private static 메서드
    private static void privateStaticMethod() {
        System.out.println("비공개 스태틱 메서드");
    }
    
    //6. private 메서드
    private void privateMethod() {
        System.out.println("비공개 바디가 구현된 메서드...");
    }
    
}//end interface....

class TestImpl implements Test{
    @Override
    public void test() { //interface를 구현하는 클래스....
        System.out.println("구현 메서드 test");
    }
}//end class TestImpl...

public class InterfaceMain02 {

    public static void main(String[] args) {
        Test.staticMethod(); //인터페이스의 퍼블릭 스태틱 메서드 호출....
      
       Test t = new TestImpl();
       t.defaultMethod();
       t.test();
    }

}
