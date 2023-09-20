package com.itwill.modifier08;

/**
 * access 수식어(private, protected, public)는 지역 변수에는 사용할 수 없음....
 * final 수식어....: 클래스, 클래스 멤버(필드, 생성자, 메서드), 지역변수(메서드 안에서 선언하는 변수)를 수식.
 * final의 의미: 변경할 수 없는...
 * final 필드/지역변수는 초기화된 값을 변결할 수 없는 변수... 상수(constant).
 * final 필드는 
 * 1) 선언과 동시에 초기화를 하거나. 
 * 2) 반드시 아규먼트를 갖는 생성자를 선언해서 명시적으로 초기화해야 함.
 * 
 */

public final class ModifierMain08 { //final class 
    // 1)  final 필드를 선언과 동시에 초기화...
    
    private final String s = "hello"; 
    
    // 2) final 필드를 선언할 때 초기화하지 않는 경우....생성자에서 명시적을 초기화해야 함....
    private final int n;
    //생성자..
    public ModifierMain08(int n) {
        this.n = n;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        final int x = 1;
        //x = 2; cannot assign 할당할 수 없음....! 컴파일 에러
        //final 지역 변수는 값을 할당(저장)할 수 없음....
      
        
        
    }

}
