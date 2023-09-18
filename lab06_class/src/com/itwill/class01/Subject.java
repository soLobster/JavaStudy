package com.itwill.class01;

//클래스 = 데이터(필드) + 초기화(생성자) + 기능(메서드) => 데이터 타입.

public class Subject {
 
    
    // 필드(field). 멤버 변수.
    int java; // 저장할 수 있는 설계도라 생각.
    int sql; // 초기화도 안된 상태.
    int js;
    
    //생성자(constructor)
    //객체를 생성(메모리를 확보)하고. 객체의 필드들을 초기화하는 역할. 담당....!
    //생성자의 이름은 반드시 클래스의 이름과 같아야한다.
    //메서드를 작성하는 방법과 비슷한다. 다른점 하나!
    //리턴타입을 쓰지 않는다....!
    //클래스를 작성할 때 생성자를 하나도 정의하지 않으면, 자바 컴파일러가 "기본 생성자"를 자동으로 만들어준다.
    //클래스를 작성할 때 생성자를 직접 작성하면, 자바 컴파일러는 기본 생성자를 자동으로 만들지 않음.
    //생성자 오버로딩(Over Loading) 생성자를 여러개 정의하는 것.
    
    //아규먼트 없는 생성자.
    public Subject() {
        // 아무 코드를 작성하지 않아도 됨.
        // 하지만 블록 괄호는 생략할 수 없음.
    }
    
    //아규먼트를 갖는 생성자. - 아규먼트의 값들로 필드를 초기화한다.
    public Subject(int java,int sql,int js) { //this! 파라미터가 달라야 한다 메서드 오버로딩
       this.java = java; //이 경우 this 생략 불가....(필드와 파라미터를 구분해야한다)
       this.sql =sql;
       this.js =js;
    }
    
    //메서드(기능)
    //1.총점
    //2.평균값.
    
    public int getTotal() {
        return this.java + this.sql + this.js; //필드는 메서드가 사용할 수 있다.
    }
    
    public double getMean() {
        return (double) this.getTotal()/ 3; //이 this는 생략가능하다.
        //지역변수와 필드가 혼동되지 않을 경우 this 생략 가능.
    }
    
    
    //기본 생성자 (default constructor).
    //아규먼트를 전달받지 않는 생성자.
    //일반적으로 필드 타입의 기본값으로 필드들을 초기화 한다.
    // - 정수 기본값: 0, 실수 기본값: 0.0, boolean 기본값 false 
    // 나머지 참조타입 -> null (ex String)
    
    
} //end class subject
