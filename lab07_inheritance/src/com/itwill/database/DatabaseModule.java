package com.itwill.database;

public interface DatabaseModule {
//필드 선언
    int DB_VERSION = 1; //상수 public static final 생략된거라 봐야한다.
    
    /*
     * 데이터베이스의 테이블에서 자료들을 읽어서 정수를 리턴하는 기능.
     * @return 검샏괸 자료 개수.
     */
    
    int select(); //바디 없이 세미콜론으로 끝냄 -> 추상 메소드이다. //public abstract 수식어가 생략 되어 있다.
    
    /*
     * 데이터베이스의 테이블에 문자열을 저장하는 기능이다.
     * @param value. 테이블의 저장할 문자열.
     * @return 저장 성공하면 1, 실패하면 0.
     */
    
    int insert(String value);
    
    
    
}
