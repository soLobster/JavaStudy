package com.itwill.inheritance05;

class T {}


public class InheritanceMain05 {

    public static void main(String[] args) {
        // java.lang.Object....자바의 최상위 클래스...
        // 자바의 모든 클래스는 Object를 상속받는다(확장한다). -> 
        // object 클래스의 메서드를 하위 타입 객체에서 사용할 수 있음,,,,
        // object 클래스의 메서드들을 하위 클래스에서 재정의 (오버라이드)할 수 있음...
        // -> toString(), equals(), hashCode() ,.....
        // java -> 라는 이름이 제일 앞에 올 수 없다.....JDK,ORACLE만 쓸 수 있다....
        // PACKAGE 이름 JAVA NOPE
        
        T t = new T();
        
        
    }

}
