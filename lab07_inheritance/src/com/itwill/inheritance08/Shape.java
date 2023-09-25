package com.itwill.inheritance08;

public abstract class Shape { //추상 클래스 되어벌임....!
    //객체를 생성할 수 음슴....
    //필드 선언은 간응...
    //같은 패키지 or 상속
    protected String type; //직사각형, 원, 삼각형....


    //추상 클래스도 생성자를 만들 수 있다.
    //호출이 불간응....
    protected Shape(String type) { //protected 모든 클래스 x 상속받는 클래스까지만.
        this.type = type;
    }

    //추상 메서드 선언....
    public abstract double area(); //도형의 넓이를 리턴하는 메서드.
    public abstract double perimeter(); //도형의 둘레를 리턴하는 메서드..

    //final 메서드 - 하위 클래스에서 재정의(override) 할 수 없는 메서드.
    public final void draw() {
        String info = String.format("%s[넓이=%f, 둘레=%f]", 
                type, area(), perimeter());
        System.out.println(info);
    }
}
