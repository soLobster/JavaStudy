package com.itwill.inheritance04;

/*
 * final 변경할 수 없는 최종적인 상수.
 * -> 지역변수, 값을 초기화하면 그 값을 변경할 수 없는(재할당할 수 없는) 지역 변수. 
 * -> 필드 반드시 한 번은 (명시적으로) 초기화해야 하고, 초기화 이후에는 값을 변경할 수 없는 필드
 * 1) final 필드를 선언과 동시에 초기화를 해도 됨.
 * 2) final 필드를 초기화할 수 있는 아규먼트를 갖는 생성자를 작성.
 * final 메서드... 변경할 수 없는 메서드....재정의(override) 할 수 없는 메서드.
 * final 클래스... 변경할 수 없는 클래스....상속 받을 수 없는(확장 할 수 없는) 클래스....
 * ex) java.lang.System, java.lang.String 이것을 상속받아서 새로운 클래스를 만들 수 없다...
 */


//class SubSystem extends System {}  확장 못하게 막아버림 (Final) 클래스

final class Super {}
//class Sub extends Super{} // 컴파일 에러... Super는 파이널로 선언 된 클래스라 상속 받지 못한다.

class A {
    public void test1() {
        System.out.println("test1");
    }
    public final void test2() {
        System.out.println("test2");
    }
}

class B extends A {
    @Override //-> 파이널이 아닌 메서드는 하위 클래스에서 재정의할 수 있음....
    public void test1() {
        System.out.println("test1");
    }
    
//    public final void test2() { //상위 타입의 final 메서드는 재정의 할 수 없음....컴파일 에러...
//        System.out.println("test2");
//    }
}

public class InheritanceMain04 {

    public static final int MAX = 100;
    //파이널 초기화...............명시...................!!!!!!
    private final int n;
    
    public InheritanceMain04(int n) {
        this.n = n;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
       

    }

}
