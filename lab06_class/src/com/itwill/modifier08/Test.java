package com.itwill.modifier08;

public class Test {
    int instanceVar;//instance 필드...
    static int staticVar; // static 필드...이텔릭체...-> static....
    //사용하는 방법이 다르다....
    
    
    //instance 메서드...(static이 붙어 있지 않는 메서드)
    //참조변수가 있어야 호출가능한 메서드.
    public void printVariables() {
        System.out.println("----인스턴스 메서드----");
        System.out.println("instanceVar >> "+instanceVar); //(=this.instanceVar)
        System.out.println("staticVar >> "+staticVar); //(=Test.staticVar)
        System.out.println("-----------------------");
    }
    //static 메서드 수식어는 무조건 리턴타입 앞에 와야한다....
    //클래스 이름만으로 호출 가능한 메서드.
    public static void printVariables2() {
        System.out.println("------static 메서드--------");
//      System.out.println("instanceVar >> "+instanceVar);//스테틱 메서드에선 스테텍이 아닌것(=인스턴스 멤버)을 접근하려하면 안된다...
        System.out.println("staticVar >> "+staticVar); //스테틱 필드 접근 가능...!!! / 스테틱 변수만 사용 가능하다.
        System.out.println("---------------------------");
    }
}
