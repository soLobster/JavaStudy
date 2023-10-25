package com.itwill.jdbc;

//상수들만 정의하기 위한 인터페이스
public interface OracleJdbc {
    
    //오라클 데이터베이스에 접속하기 위한 서버 주소
    String URL = "jdbc:oracle:thin:@192.168.20.13:1521:xe";
    
    //오라클 데이터베이스에 접속할 수 있는 계정 이름.
    String USER = "scott";
    
    //오라클 데이터베이스에 접속 계정의 비번.
    String PASSWORD = "tiger";
    
}
