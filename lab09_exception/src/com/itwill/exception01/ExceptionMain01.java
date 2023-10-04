package com.itwill.exception01;
/*
 * 오류(error) vs 예외(exception)...
 * 오류의 종류
 * 1. 시스템 에러 : 메모리 부족(OOM, out of memery) -> 수정 매우 힘듦, 불가능 한 경우도 있음.
 * 2. 컴파일 에러 : 문법 오류 -> 반드시 수정...!
 * 3. 논리적인 에러 : 프로그램이 정상적으로 컴파일 되고 실행/종료가 되지만, 원하는 결과가 나오지 않음...
 * -> 반드시 수정, 수정 힘듦....
 * 
 * 예외 : 프로그램 실행 중에 발생할 수 있는 비정상적인 상황 -> 반드시 수정...
 * 1) if-else 문장
 * 2) try-catch 문장
 * 
 */
public class ExceptionMain01 {

    public static void main(String[] args) {
        // 예외 종류 & 해결 방법...
        String s = "";
        if(s != null) {
            System.out.println("문자열 길이: "+s.length());
        } else {
            System.out.println("null");
        }
        
        int x = 10;
        int y = 0;
        if(y != 0) {
            System.out.println("몫 = "+(x/y));    
        } else {
            System.out.println("0으로는 나눌 수 없습니다.");
        }
          
    }

}
