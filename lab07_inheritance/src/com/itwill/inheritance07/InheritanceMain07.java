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
 *  추상 클래스는 객체를 생성할 수 없다. 생성자를 호출할 수 없음...
 *  
 *  왜 하느냐????
 *  추상메서드와 추상 클래스는 상속하는 하위 클래스에서 구현을 목적으로 함...
 *  바디를 만들어 준다...?
 *  반드시 구현을 하도록 강제하는게 목적임.
 */
abstract class Animal { //추상 클래스...
    //public void move() {} //이놈은 추상 메서드가 아니다.
    public abstract void move(); //추상 메서드...
}

class Dog extends Animal {
    @Override //Animal의 move를 오버라이드한다.
    public void move() {
        System.out.println("강아지는 총총총.....");
    }
}

class Fish extends Animal{
    @Override
    public void move() {
       System.out.println("물고기는 물물물...."); 
    }
}

public class InheritanceMain07 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // 추상클래스 Animal 타입으로 객체 생성.
        //Animal a = new Animal();//Cannot instantiate...인스턴스화 할 수 없다...객체를 생성할 수 없다. 컴파일 에러.
        System.out.println();
    }

}
