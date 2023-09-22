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
       
        System.out.println("======");
        //다형성 Polymorphism...을 사용한 변수 선언과 초기화....
        //SuperType으로 변수 = new SubType...
        Car car3 = new HybridCar(30, 60, 90); //실제로 만들어진 객체가 중요하다.....
        car3.drive();
        //-> 다형성으로 선언된 변수인 경우, 재정의(오버라이드)된 메서드가 실행 된다....
        //car3.charge() -> HybridCar에 있기에 죽어도 보이지 않는다...!
        //실제 객체는 HybridCar이지만, Car타입으로 선언 했기 때문에 
        //Car 타입의 메서드들만 사용가능한거다.
        System.out.println("=======");
        ((HybridCar) car3).charger(100); //이케 하면 car3. 해도 HybridCar로 나온다...
        //케스팅 했을 때만 하이브리드의 메서드를 사용할 수 있는것 
        //그 밑으로는 사용 불가 !....는 아니다 어떤 변수에 저장하면 쓸 수는 있음.
        //실제 생성된 객체는 하브차 타입 이기 때문에, 타입변환(Casting)이 가능...!
        //타입 변환 후에는 HybridCar 타입의 모든 메서드들을 사용할 수 있게 된다...
        
        car3.drive();
        //좌우 변수 선언 타입과 -> 생성자 타입이 다를 수 있다...
        //Car가 부모,,,,HybirdCar가 자식,,,,,
        //SubType 좌 SuperType 우 -> 컴파일 에러 발생.
        //일반 차를 하브라 부를 수 없다....!!! ㄹㅇㄹㅇ
        //하브차를 일반차라 부를 수 있다....!!! ㄹㅇㄹㅇ

    }
}
