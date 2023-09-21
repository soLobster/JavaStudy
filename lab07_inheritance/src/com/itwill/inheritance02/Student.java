package com.itwill.inheritance02;

//Student - subclass, Person - superclass....

public class Student extends Person {
    //필드 확장...
    private String schoolName;

    //생성자 생성...고민 곰곰...
    public Student() {
        System.out.println("Student() 호출");
    } //기본 생성자....
    
    
    
    //getter, setter.
    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

}
