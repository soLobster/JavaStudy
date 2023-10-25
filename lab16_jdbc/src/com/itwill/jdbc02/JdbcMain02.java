package com.itwill.jdbc02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.jdbc.OracleDriver;

import static com.itwill.jdbc.OracleJdbc.*;

public class JdbcMain02 {

    public static void main(String[] args) {
        // JDBC를 활용한 insert

        Scanner sc = new Scanner(System.in);

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // 1. OracleDriver 등록.
            DriverManager.registerDriver(new OracleDriver());

            // 2. Connection 생성
            conn = DriverManager.getConnection(URL,USER,PASSWORD);

            // 3. Statement 생성.
            final String sql = "insert into BLOGS (TITLE, CONTENT, AUTHOR) values(?, ?, ?)";
            pstmt = conn.prepareStatement(sql);

            // 테이블에 insert하기 위해서 필요한 정보들을 입력받음.
            System.out.print("제목을 입력 > ");
            String title = sc.nextLine();
            System.out.print("내용을 입력 > ");
            String content = sc.nextLine();
            System.out.print("작성자는 누구 인가요? > ");
            String author = sc.nextLine();


            // Statement 객체의 ?로 비워져 있는 부분에 값들을 채운다.
            pstmt.setString(1, title); // 첫번째 물음표를 title 변수 값을 채움
            pstmt.setString(2, content);
            pstmt.setString(3, author);

            // Statement를 실행. & 결과 처리
            int result = pstmt.executeUpdate();
            System.out.println(result+"개 행이 삽입됐습니다.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 리소스 해제
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }// end of main

}// end of class
