package com.itwill.switch03;

//enum: enumerate Type.(열거형 타입)
//상수들을 정의하는 특별한 종류의 class.
//변수 이름들을 나열(열거)한것.
//enum의 이름이 변수 타입.
//따로 변수 타입을 지정하지 않는다.
//대소문자를 구분한다. 

//변수(variable) : 값을 저장하기 위한 메모리 공간.
//상수(constant) : 초기화한 이후에는 값을 변경할 수 없는 변수.
//리터럴(literal): 고정된 값. EX) 1,2, 3.14, "abcd",....
//int x = 1; -> x: 변수, 1: 리터럴.
//final int x = 1; <final 다시는 바꿀 수 없는 값> 변수이면서 상수이다.(constant variable).

public enum WeekDay {
        
    SUN, MON, TUE, WED, THU, FRI, SAT;
    
}
