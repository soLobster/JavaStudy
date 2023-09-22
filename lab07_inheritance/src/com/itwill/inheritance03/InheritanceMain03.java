package com.itwill.inheritance03;

public class InheritanceMain03 {

    public static void main(String[] args) {
        // Car
        
        Car car1 = new Car(50,30);
        
        car1.drive();
        
        System.out.println("======");
        
        HybridCar car2 = new HybridCar(30, 40, 100);
        
        car2.drive();
    }

}
