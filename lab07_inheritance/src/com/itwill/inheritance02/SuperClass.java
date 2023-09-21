package com.itwill.inheritance02;

public class SuperClass {

    private int a;

    //public SuperClass() {} //기본 생성자..

    public SuperClass(int a) {
        //this(); -> 위의 기본 생성자를 호출하는 의미...[overLoading] 기본 생성자 호출.
        this.a = a;
        //this의 의미 -> SuperClass(자기 자신) -> Private int a의 주소.
    }



}
