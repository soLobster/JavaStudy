package com.itwill.modifier08;

/**
 * access 수식어(private, protected, public)는 지역 변수에는 사용할 수 없음....
 * final 수식어....: 클래스, 클래스 멤버(필드, 생성자, 메서드), 지역변수(메서드 안에서 선언하는 변수)를 수식.
 * final의 의미: 변경할 수 없는...
 * final 필드/지역변수는 초기화된 값을 변결할 수 없는 변수... 상수(constant).
 * final 필드는 
 * 1) 선언과 동시에 초기화를 하거나. 
 * 2) 반드시 아규먼트를 갖는 생성자를 선언해서 명시적으로 초기화해야 함.
 */


/**
 * 객체(object)...프로그램에서 만들 대상.(비유) 붕어빵.
 * 클래스(class)...객체를 생성하기 위한 프로그램 코드, 설계도.....클래스 이름은 데이터 타입이다. (비유) 붕어빵 틀.
 * 인스턴스(instance)...메모리에 생성된 객체를 인스턴스라 한다....(비유) 만들어진 붕어빵....
 * instantiate...인스턴스화하다. 객체를 생성하다..... 생성자 호출.
 * 
 * 클래스의 멤버(필드, 메서드).
 * 1) instance(필드,메서드) 멤버. 
 *  1 static 수식어가 사용되지 않은 멤버
 *  2 객체를 생성한 후에(생성자를 호출한 다음) 참조 변수를 이용해서 사용하는 멤버.....
 *  3 JRE(java runtime environment)이 사용하는 메모리 공간 중에서 힙(heap)에 생성되는 변수....
 *  
 * 2) static(필드,메서드)(정적) 멤버.
 *  1 static 수식어가 사용된 멤버
 *  2 객체를 생성하지 않아도 사용할 수 있는 멤버.
 *  3 클래스 이름을 이용해서 사용하는 멤버.ex) Math.PI , Math.sqrt(),.....
 *  4 힙에 생성되지 않고 JRE가 사용하는 메모리 공간 중에서 메서드 영역에 생성되는 변수.
 *  5 프로그램 main() 메서드가 호출되기 전에 프로그램 로딩 시점에 메모리에 생성.
 *  6 static 메서드는 static 필드와 메서드만 접근 가능.
 *  
 */

public final class ModifierMain08 { //final class 
    // 1)  final 필드를 선언과 동시에 초기화...
    
    private final String s = "hello"; 
    
    // 2) final 필드를 선언할 때 초기화하지 않는 경우....생성자에서 명시적을 초기화해야 함....
    private final int n;
    //생성자..
    public ModifierMain08(int n) {
        this.n = n; //final 필드를 명시적으로 초기화....
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        final int x = 1;
        //x = 2; cannot assign 할당할 수 없음....! 컴파일 에러
        //final 지역 변수는 값을 할당(저장)할 수 없음....
        
        //스태틱 멤버 사용방법.... 클래스 이름을 접두사로 사용한다....객체 생성 전에도 사용가능....
        System.out.println(Test.staticVar);
        Test.staticVar = 1;
        System.out.println(Test.staticVar);
        Test.printVariables2();
        
        //System.out.println(Test.printVariables2());
        //인스턴스 멤버 사용방법....참조 변수를 이용한다. 객체를 생성한 후에 사용이 가능하다.
        
        System.out.println();
        
        Test t1 = new Test();
        t1.instanceVar = 100;
        t1.printVariables();
        
        System.out.println();
        
        Test t2 = new Test();
        t2.instanceVar = 1010;
        t2.staticVar = 12345; 
        //-> 경고 발생 스태틱 필드를 마치 인스턴스 변수처럼 사용하고 있음(나쁜 코드)...
        //   좋은 코드 :  Test.staticVar = 12345;
        //   자바가 허용한다.....글로벌 변수(전역변수)....
        t2.printVariables();
        
        t1.printVariables(); //Line 73에서 변경한 값이 메서드 호출에 영향을 미친다.
        
        
    }

}
