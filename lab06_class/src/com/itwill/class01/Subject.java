package com.itwill.class01;

public class Subject {
 
    
    // 필드(field). 멤버 변수.
    int java; // 저장할 수 있는 설계도라 생각.
    int sql; // 초기화도 안된 상태.
    int js;
    
    //생성자(constructor)
    //객체를 생성하고. 객체의 필드들을 초기화하는 역할. 담당....!
    //생성자의 이름은 반드시 클래스의 이름과 같아야한다.
    //메서드를 작성하는 방법과 비슷한다. 다른점 하나!
    //리턴타입을 쓰지 않는다....!
    
    //아규먼트 없는 생성자.
    public Subject() {
        // 아무 코드를 작성하지 않아도 됨.
        // 하지만 블록 괄호는 생략할 수 없음.
    }
    
    //아규먼트를 갖는 생성자. - 아규먼트의 값들로 필드를 초기화한다.
    public Subject(int java,int sql,int js) { //this!
       this.java = java;
       this.sql =sql;
       this.js =js;
    }
    
    //기본 생성자 (default constructor).
    //아규먼트를 전달받지 않는 생성자.
    //일반적으로 필드 타입의 기본값으로 필드들을 초기화 한다.
    // - 정수 기본값: 0, 실수 기본값: 0.0, boolean 기본값 false 
    // 나머지 참조타입 -> null (ex String)
    
    
}
