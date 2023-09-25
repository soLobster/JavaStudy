package com.itwill.inheritance07;

/*
 * 추상 메서드. (abstract method)...
 * 메서드의 signature. 수식어, 리턴 타입, 메서드 이름, 파라미터 선언...만 선언되어 있고,
 * 본체(body, block)이/가 정의되어있지 않은 메서드를 추상 메서드라 부른다.
 * 부를 수 없는 메서드.
 * 반드시 abstract라는 키워드로 수식해야 한다.
 * 추상 메서드 선언은 반드시 세미콜론으로 끝나야 한다(;).
 * 바디가 있다면 abstract를 붙이면 안된다.
 *  
 *  추상 클래스 (abstract class)...
 *  abstract라고하는 수식어가 사용된 클래스...
 *  클래스는 바디가 있든 없든 추상메서드를 갖든 안갖든 
 *  abstract를 사용 할 수 있다.
 *  대부분의 경우 추상 클래스는 한개 이상의 추상 메서드를 갖고 있는 경우가 많다...
 *  클래스에 추상 메서드가 있는 경우에는 반드시 추상 클래스로 선언해야만 한다.
 */
abstract class Animal { //추상 클래스...
    //public void move() {} //이놈은 추상 메서드가 아니다.
    public abstract void move(); //추상 메서드...
    
}


public class InheritanceMain07 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
 