package com.itwill.class02;

//클래스 = 데이터 + 초기화 + 기능

public class Rectangle {

    //필드....
    double width;
    double height;
    
    //생성자....
    //기본생성자
    public Rectangle() { //public 다른 클래스에 공개 하겠다.
        // 생성자의 이름은 클래스와 같아야한다.
    }
    
    //아규먼트를 갖는 생성자.
    public Rectangle(double width, double height) { //필드의 이름과 파라미터의 이름이 같은 경우
        this.width = width;                         //필드를 구분하기 위해서 필드는 this를 쓴다.
        this.height = height;
    }
    
    //메서드
    
    
    //넓이 
    public double getArea() {
        return width*height;
        //필드와 지역변수 이름이 같지 않은 경우에는 필드 앞에 this를 생략해도 됨.
    }
    
    //둘레
    public double getPerimeter() {
        return (width+height)*2;
    }
    
} //end class Rectangle.

