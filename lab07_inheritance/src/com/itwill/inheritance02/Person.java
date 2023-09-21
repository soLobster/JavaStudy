package com.itwill.inheritance02;

//학생은 사람이다.....학생은 사람을 확장(상속)한다....

//사람 - superclass, 학생-subclass...

public class Person {
    //사람이라는 객체가 가져야하는 속성 필드로 정의
    private String name;
    
    public Person() {}//기본 생성자...
    
    
    public Person(String name) {
        this.name = name;
    }//생성자....

    //getter, setter
    
    public String getName() {
        return this.name;
    }//getter
    
    public void setName(String name) {
        this.name = name;
    }//setter

}//end of Person class...


