package com.itwill.jdbc.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.itwill.jdbc.model.Blog;

import oracle.jdbc.OracleDriver;

import static com.itwill.jdbc.OracleJdbc.*;

//MVC 아키텍처에서 Controller에 해당하는 클래스: DB select, insert, update, delete.
//DB CRUD(Create, Read, Update, Delete)
public class BlogDao {
    //--- singleton 
    private static BlogDao instance = null;

    private BlogDao() {
        // 오라클 데이터베이스를 접속할 수 있는 드라이버(라이브러리)를 등록.
        try {
            DriverManager.registerDriver(new OracleDriver());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static BlogDao getInstance() {
        if(instance == null) {
            instance = new BlogDao();
        } 
        return instance;
    }//---singleton

    public static final String SQL_SELECT_ORDER_BY_ID = 
            "select * from BLOGS order by ID desc";

    /**
     * 데이터베이스의 BLOGS 테이블에서 모든 레코드(행)를 검색해서 리스트를 리턴.
     * 검색 결과는 블로그 포스트 번호의 내림차순으로 정렬.
     * 테이블에 행이 1개도 없는 경우에는 빈 리스트를 리턴한다.
     * 
     * @return 블로그들의 리스트
     */
    public List<Blog> read() {
        List<Blog> result = new ArrayList<Blog>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            // 오라클 데이터베이스에 접속.(세션 생성)
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            // 실행할 Statement 객체를 생성한다.
            stmt = conn.prepareStatement(SQL_SELECT_ORDER_BY_ID);
            // SQL 문장을 DB에서 실행한다.
            rs = stmt.executeQuery();

            // 결과 처리.
            while(rs.next()) {
                int id = rs.getInt("ID");
                String title = rs.getString("TITLE");
                String content = rs.getString("CONTENT");
                String author = rs.getString("AUTHOR");
                LocalDateTime created = rs.getTimestamp("CREATED_TIME").toLocalDateTime();
                LocalDateTime modified = rs.getTimestamp("MODIFIED_TIME").toLocalDateTime();

                Blog blog = new Blog(id, title, content, author, created, modified);
                result.add(blog);
            }//while

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return result;

    }//List<Blog> read() method 


}//end of class
