package com.itwill.class03;

public class AppMain03 {

    public static void main(String[] args) {
        // 객체 생성, 초기화, 메서드 호출 연습....
        Circle circle1 = new Circle();
        
        System.out.println("circle Area = "+circle1.circleRadius);
        circle1.circleRadius = 3;
        System.out.println("circle Area = "+circle1.circleRadius);
        System.out.println("circle1 Area = "+circle1.circleArea());
        System.out.println("circle1 Perimeter = "+circle1.circlePerimeter());
        System.out.println("==================");
        Circle circle2 = new Circle(3);
        System.out.println("circle2 Area = "+circle2.circleArea());
        System.out.println("circle2 Perimeter = "+circle2.circlePerimeter());
    }

}
