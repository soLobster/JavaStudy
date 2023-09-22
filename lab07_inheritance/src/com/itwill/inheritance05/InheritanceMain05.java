package com.itwill.inheritance05;

import java.util.Random;
import java.util.Scanner;

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
        System.out.println(t.getClass());
        System.out.println(t.toString());
        int hash = t.hashCode(); //해시코드를 리턴....
        System.out.println(t.hashCode()+"\t"+ Integer.toHexString(hash));
        System.out.println(t.equals(t));
        
        //-> System.out.println(Object o) 메서드는 객체의 문자열 표현식을 콘솔에 출력.
        //-> println 메서드는 객체가 가지고 있는 toString()에 리턴값을 출력.
        Random read = new Random();
        System.out.println(read);
        //-> Random 클래스는 toString 메서드를 재정의 하지 않았음...
        
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner);
        //-> scanner 클래스는 toString 메서드를 오버라이딩 하고 있음...
        
        
        T t2 = new T();
        System.out.println(t.equals(t2));
        System.out.println(t2.toString());
        int hash2 = t2.hashCode();
        System.out.println(t2.hashCode()+"\t"+Integer.toHexString(hash2));
        
        T t3 = t;
        System.out.println(t.equals(t3));
        int hash3 = t3.hashCode();
        System.out.println(t.hashCode()+"\t"+hash3);
        
        
        //equals 메서드가 재정의된 예.
        String s1 = new String("Java"); //사용하지 않는게 좋다.
        String s2 = new String("Java");
        
        System.out.println(s1 == s2); //false //지역변수 (주소값) 문자열 비교를 숫자 비교 하듯 하면 절대 안된다.
        // -> 비교연산자(==) 참조 변수의 저장된 객체의 참조값을 비교
        System.out.println(s1.equals(s2)); //true 문자열 비교시엔 equals 메서드를 사용하자.....
        // -> String 클래스에서 equals 메서드는 문자열 내용이 같으면
        // (실제로 생성된 문자열 객체가 다르더라도) true를 리턴하도록 재정의(over_ride) 되어 있음.
        
        System.out.println(s1);
        System.out.println(s2);
        
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
    }
    

}
