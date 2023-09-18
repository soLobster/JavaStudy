package com.itwill.class03;

public class AppMain03 { //클래스

    public static void main(String[] args) {
        // 객체 생성, 초기화, 메서드 호출 연습....
        Circle circle1 = new Circle(); //만들어진 객체 -> 인스턴스.
        System.out.println(circle1);
        System.out.println("circle Radius = "+circle1.circleRadius);
        circle1.circleRadius = 3;
        
        System.out.println("circle Radius = "+circle1.circleRadius);
        System.out.println("circle1 Area = "+circle1.circleArea());
        System.out.println("circle1 Perimeter = "+circle1.circlePerimeter());
       
        System.out.println("==================");
        
        Circle circle2 = new Circle(1.0);
        System.out.println(circle2);
        System.out.println("circle2 Area = "+circle2.circleArea());
        System.out.println("circle2 Perimeter = "+circle2.circlePerimeter());
       
    }

}
