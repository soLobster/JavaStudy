package com.itwill.exception06;

public class Calculator {
    
    public int divide(int x, int y) throws Exception { //주어 동사 목적어 --> 3인칭 단수 throws 가 나온다....
        
        if(y != 0) {
            return x/y; //메서드를 호출한 곳에 값을 반환.
        }
        
        //메서드를 호출한 곳에 예외를 던진다.
        throw new Exception("y는 0이 될 수 없습니다."); // -> 여긴 그냥 throw ...
    }
}