package com.itwill.inheritance03;

public class InheritanceMain03 {

    public static void main(String[] args) {
        // Car
        
        Car car1 = new Car(50,30);
        
        car1.drive();

        System.out.println("======");
        
        HybridCar car2 = new HybridCar(30, 40, 100);
        
        
        //오버라이딩을 통해 재정의를 해버리면 객체가 재정의 값만 나오게 된다.
        //즉, 부모의 메소드는 은닉되고 자식 클래스의 재정의된 메소드만 호출된다. 
        car2.drive();
        
    }

}
