package com.itwill.jdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;

import com.itwill.jdbc.model.Blog;

import oracle.jdbc.OracleDriver; // <- 이놈을 임포트해야한다. 
// ojdbc11.jar에 포함된 클래스.

// public static 으로 선언된 상수, 메서드 이름을 임포트 하는 방법 - > Static import
import static com.itwill.jdbc.OracleJdbc.*;

/*
 * JDBC(java database Connectivity)
 * 자바 프로그램에서 데이터베이스를 연결하고, SQL 문장들을 실행해서 그 결과를 처리.
 * 
 * 1. Oracle Jdbc 라이브러리를 다운로드하고 이클립스 프로젝트에 추가.
 * Maven Central 
 * - search.maven.org
 * - ojdbc 검색
 * - com.oracle.database
 * -> ojdbc11, ojdbc8 (가능하면 높은 버전, 상황에 맞게 선택)
 * - download jar 파일
 * - 프로젝트에 lib 폴더 생성 (src와 같은 트리에서 생성 not src 내부)
 * - lib에 jar 파일 copy paste 
 * - jar 우클릭 build path -> add to build path
 * 추후엔 Maven Tool을 사용할 예정
 * 
 * 2. 데이터베이스에 접속하기 위한 정보들(url, user, password, ...)을 상수로 정의.
 * 
 * ----- main에서 작성
 * 3. 프로그램에서 오라클 jdbc 라이브러리를 메모리에 로딩해야한다. (java 코드로 작성)
 * 4. 오라클 데이터베이스에 접속한다.
 * 5. Statement 타입 객체 생성. - DB에서 실행할 SQL 문장을 작성하고, 실행할 수 있는 객체.
 * 6. Statement 타입 인스턴스에서 메서드를 호출해서 SQL을 실행
 *  - 1) executeQuery(): DQL에서 사용 (Select)
 *  - 2) executeUpdate(): DML에서 사용 (Insert)
 * 7. 실행결과를 처리.
 * 8. 사용했던 모든 리소스를 해제(close).
 */

public class JdbcMain01 {

    public static void main(String[] args) {
        // 3. Oracle JDBC 라이브러리(Driver)를 사용할 수 있도록 메모리에 로딩.

        Connection conn = null; // 객체 생성 - try 구문 , 해제 - finally 구문.
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            DriverManager.registerDriver(new OracleDriver());
            System.out.println("오라클 드라이버 등록 성공");

            // 4. 오라클 데이터베이스에 접속.(세션 생성)
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("오라클 데이터베이스 접속 성공");

            // 5. Statement 객체 생성.
            final String sql = "select * from BLOGS order by ID desc";
            //-> JDBC에서는 SQL 문장을 작성할 때 세미콜론을 사용하지 않음!!!
            pstmt = conn.prepareStatement(sql);
            
            // 6. Statement를 실행 - SQL 문장을 DB 서버로 보내서 실행.
            rs = pstmt.executeQuery(); 
            
            // 7. 결과 처리. while
            while(rs.next()) { // rs.next() 테이블에 자료가 있는지 확인 있다면 true를 리턴하고 다음 행으로 
                int id = rs.getInt("ID"); // id 컬럼의 숫자를 읽어온다.
                String title = rs.getString("TITLE"); // title의 
                String content = rs.getString("CONTENT");
                String author = rs.getString("AUTHOR");
                LocalDateTime createdTime = rs.getTimestamp("CREATED_TIME").toLocalDateTime();
                LocalDateTime modifiedTime = rs.getTimestamp("MODIFIED_TIME").toLocalDateTime();
                
                Blog post = new Blog(id, title, content, author, createdTime, modifiedTime);
                System.out.println(post);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 8. 리소스 해제: 객체들이 생성된 순서의 반대로 해제를 해야한다.
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }//end of main

}//end of class
