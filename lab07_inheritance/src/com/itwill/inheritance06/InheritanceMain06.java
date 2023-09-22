package com.itwill.inheritance06;

public class InheritanceMain06 {

    public static void main(String[] args) {
        // Point 타입 객체 생성.
        Point p1 = new Point();
        System.out.println(p1);
        
        Point p2 = new Point(0.0,0.0);
        System.out.println(p2);
        
        System.out.println(p1.equals(p2));
        
        System.out.println(System.identityHashCode(p1));;
        System.out.println(System.identityHashCode(p2));;
        
    }
    //Object 클래스에서 toString 메서드는 "패키지.클래스@해시코드" 형식의 문자열을 리턴.
    //Object 클래스에서 상속받은 toString을 재정의(over_ride)하게 되면 콘솔 출력 내용을 변경 할 수 있게 된다.
    
    
}
