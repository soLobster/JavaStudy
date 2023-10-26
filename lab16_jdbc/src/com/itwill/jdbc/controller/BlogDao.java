package com.itwill.jdbc.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    private void closeResources(Connection conn, Statement stmt, ResultSet rs) {
        try {
            rs.close();
            closeResources(conn, stmt);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void closeResources(Connection conn, Statement stmt) {
        try {
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private Blog makeBlogFromResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("ID");
        String title = rs.getString("TITLE");
        String content = rs.getString("CONTENT");
        String author = rs.getString("AUTHOR");
        LocalDateTime created = rs.getTimestamp("CREATED_TIME").toLocalDateTime();
        LocalDateTime modified = rs.getTimestamp("MODIFIED_TIME").toLocalDateTime();
        
        Blog blog = new Blog(id, title, content, author, created, modified);
        
        return blog;
    }
    
    
    
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
                Blog blog = makeBlogFromResultSet(rs);
                result.add(blog);
            }//while

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //리소스 해제
            closeResources(conn, stmt, rs);
        }

        return result;

    }//List<Blog> read() method 

    
    public static final String SQL_INSERT = 
            "insert into BLOGS (TITLE, CONTENT, AUTHOR) values(?,?,?)";
    
    /**
     * 데이터 베이스의 BLOGS 테이블에 행을 삽입(insert). SQL_INSERT를 실행.
     * 
     * @param blog 테이블에 insert할 값(title, content, author)을 저장한 객체.
     * 
     * @return 테이블에 Insert된 행의 개수.
     */
    public int create(Blog blog) {
        int result = 0;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = conn.prepareStatement(SQL_INSERT);
            
            stmt.setString(1, blog.getTitle());
            stmt.setString(2, blog.getContent());
            stmt.setString(3, blog.getAuthor());
            result = stmt.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            closeResources(conn, stmt);
        }
        
        return result;
    }//end create() method

    public static final String SQL_DELETE_BY_ID = 
            "delete from BLOGS where ID = ?";
    /**
     * 데이터베이스 BLOGS 테이블에서 글 번호(id)에 해당하는 레코드를 삭제. 
     * SQL_DELETE_BY_ID 문장을 실행. 삭제된 행의 개수를 리턴한다.
     * 
     * @param id 삭제하려는 포스트의 번호(ID). 테이블의 PK.
     * @return 삭제 성공이면 1, 실패이면 0.
     */
    public int delete(Integer id) {
        int result = 0;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = conn.prepareStatement(SQL_DELETE_BY_ID);
            stmt.setInt(1, id);
            
            result = stmt.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt);
        }
        
        return result;
    }//end delete() method
    
    public static final String SQL_SELECT_BY_ID = "select * from BLOGS where ID = ?";
    
    /**
     * 블로그 포스트 아이디(글 번호)로 검색해서 그 결과를 리턴.
     * SQL_SELECT_BY_ID 문장을 실행.
     * 
     * @param id 테이블에서 검색할 때 사용할 아이디. (Primary Key)
     * @return 검색 결과가 있으면 Null이 아닌 Blog 타입 객체, 검색 결과가 없으면 Null.
     */
    public Blog read(Integer id) {
        Blog blog = null;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs  = null;
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1 , id);
            
            rs = stmt.executeQuery();
            if(rs.next()) { // 검색 결과가 있으면(PK에 해당하는 레코드가 있으면)
                blog = makeBlogFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }
        
        return blog;
    }//Blog read()

    public static final String SQL_UPDATE = 
            "update BLOGS set TITLE = ?, CONTENT = ? , MODIFIED_TIME = systimestamp where ID = ?";
    
    /**
     * 데이터베이스 테이블 BLOGS에서 제목, 내용을 업데이트.
     * 업데이트할 때 modified_time 컬럼은 시스템의 현재 시간으로 업데이트.
     * SQL_UPDATE 문장을 실행하고 그 결과를 리턴.
     * 
     * @param blog 업데이트할 포스트의 아이디, 제목, 내용을 가지고 있는 객체.
     * @return 업데이트 성공하면 1, 실패하면 0.
     */
    public int update(Blog blog) {
        int result = 0;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, blog.getTitle());
            stmt.setString(2, blog.getContent());
            stmt.setInt(3, blog.getId());
            
            result = stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt);
        }
        return result;
    }//end update()
    
    // 제목에 검색 키워드가 포함된 모든 결과를 검색.(대소 구분 없이)
    public static final String SQL_SELECT_BY_TITLE = 
            "select * from BLOGS where lower(TITLE) like ? order by ID desc";
    // 컨텐트에 검색 키워드가 포함된 모든 결과를 검색.
    public static final String SQL_SELECT_BY_CONTENT = 
            "select * from BLOGS where lower(CONTENT) like ? order by ID desc";
    // 제목 또는 내용에 검색 키워드가 포함된 모든 결과를 검색.
    public static final String SQL_SELECT_BY_TITLE_OR_CONTENT = 
            "select * from BLOGS where lower(TITLE) like ? or lower(CONTENT) like ? order by ID desc";
    // 작성자에 검색 키워드가 포함된 모든 결과를 검색.
    public static final String SQL_SELECT_BY_AUTHOR = 
            "select * from BLOGS where lower(AUTHOR) like ? order by ID desc";
    
    /**
     * 검색 타입에 따라서 SQL_SELECT_BY_TITLE, SQL_SELECT_BY_CONTENT, SQL_SELECT_BY_TITLE_OR_CONTENT, SQL_SELECT_BY_AUTHOR
     * 문장을 실행하고, 그 결과를 List로 return하는 method.
     * 
     * @param searchType 0 - 제목, 1 - 내용, 2 - 제목 or 내용, 3 - 작성자
     * @param keyword 검색어
     * @return 검색 결과 리스트, 검색 결과가 없는 경우에는 빈 리스트.
     */
    public List<Blog> search(int searchType, String keyword) {
        final String searchKeyword = "%" + keyword.toLowerCase() + "%"; 
        
        List<Blog> result = new ArrayList<Blog>();
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            switch (searchType) {
            case 0: 
                stmt = conn.prepareStatement(SQL_SELECT_BY_TITLE);
                stmt.setString(1, searchKeyword);
                break;
            case 1:
                stmt = conn.prepareStatement(SQL_SELECT_BY_CONTENT);
                stmt.setString(1, searchKeyword);
                break;
            case 2:
                stmt = conn.prepareStatement(SQL_SELECT_BY_TITLE_OR_CONTENT);
                stmt.setString(1, searchKeyword);
                stmt.setString(2, searchKeyword);
                break;
            case 3:
                stmt = conn.prepareStatement(SQL_SELECT_BY_AUTHOR);
                stmt.setString(1, searchKeyword);
                break;
            }
            
            rs = stmt.executeQuery();
            while(rs.next()) {
                Blog b = makeBlogFromResultSet(rs);
                result.add(b);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }
        return result;
    }//List<> search
    
    
}//end of class
