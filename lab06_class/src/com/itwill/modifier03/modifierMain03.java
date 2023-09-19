package com.itwill.modifier03;
/*
 * 데이터 캡슐화(encapsulation)
 * 필드(멤버 변수)들을 private으로 선언해서 클래스 외부에서는 보이지 않도록 감추고,
 * 대신에 필요한 경우에 한해서 public으로 공개한 메서드를 제공해서
 * 간접적으로 필드들의 값을 읽거나 수정하는 것을 허용하는 객체지향 프로그래밍 방법.
 * 데이터의 보안과 무결성을 유지하기 위해서 캡슐화를 사용한다....
 * 
 * getter 메서드: private 필드의 값을 읽어오는 메서드....필드의 값을 리턴하는 메서드..
 * -> 리턴타입이 있다. 필드와 리턴 타입이 같다.
 * setter 메서드: private 필드의 값을 변경하는 메서드....
 * -> 리턴타입이 없다. 주로 void
 */
public class modifierMain03 {

    public static void main(String[] args) {
        //Person 타입의 객체를 생성...
        Person p1 = new Person("오쌤",16);
        System.out.println(p1.getName());
        System.out.println("오쌤의 나이 >> "+p1.getAge());

        p1.setAge(20);
        System.out.println("4년 후 오쌤의 나이 >> "+p1.getAge());
    }

}
