package com.itwill.class03;

public class Circle {
    
    //필드 선언
    double circleRadius;
    double pi = 3.14;
   
    
    //기본 생성자.
    public Circle() {
        
    }
    //아규먼트를 갖는 생성자.
    public Circle(double circleRadius) {
        this.circleRadius = circleRadius;
    }
    
    //메서드
    //원 넓이 리턴 Area
    public double circleArea() {
        return pi*circleRadius*circleRadius;
    }
    //원 둘레 리턴 Perimeter
    public double circlePerimeter() {
        return pi*circleRadius*2;
    }
}
