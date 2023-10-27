package com.itwill.gym.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.itwill.gym.model.GymMember;

import oracle.jdbc.OracleDriver;

import static com.itwill.gym.GymJdbc.*;

//MVC 아키텍처 -> Controller
//DB CRUD (Create, Read, Update, Delete).

public class GymMemberDao {
    //singlton
    private static GymMemberDao instance = null;

    private GymMemberDao() {
        // 오라클 데이터베이스를 접속할 수 있는 드라이버(라이브러리)를 등록.
        try {
            DriverManager.registerDriver(new OracleDriver());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GymMeberDao.

    public static GymMemberDao getInstance() {
        if(instance == null) {
            instance = new GymMemberDao();
        }
        return instance;
    }//static GymMemberDao getInstance() -- end singleton

    //리소스 해제.
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
    
    //결과처리.
    private GymMember makeGymMemberResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("ID");
        String name = rs.getString("NAME");
        String phone = rs.getString("PHONE");
        String gender = rs.getString("GENDER");
        Date birthday = rs.getDate("BIRTHDAY");
        String address = rs.getString("ADDRESS");
        LocalDateTime join = rs.getTimestamp("JOIN_TIME").toLocalDateTime();
        LocalDateTime modified = rs.getTimestamp("MODIFIED_TIME").toLocalDateTime();
        
        GymMember gymMember = new GymMember(id, name, phone, gender, birthday, address, join, modified);
        
        return gymMember;
    }
    
    //SQL_SELECT_ORDER_BY_ID
    public static final String SQL_SELECT_ORDER_BY_ID = 
            "select * from GYM_MEMBER order by ID desc";
    
    /**
     * 데이터베이스 GYM_MEMBER 테이블에서 모든 레코드(행)을 검색해서 리스트를 리턴.
     * 검색 결과는 회원 ID(Sequence)의 내림차순으로 정렬.
     * 테이블에 레코드가 1개도 없는 경우 빈 리스트를 리턴한다.
     * 
     * @return 전체 회원들의 리스트.
     */
    public List<GymMember> read() {
        List<GymMember> result = new ArrayList<GymMember>();
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = DriverManager.getConnection(URL, USER , PASSWORD);
            stmt = conn.prepareStatement(SQL_SELECT_ORDER_BY_ID);
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                GymMember gymMember = makeGymMemberResultSet(rs);
                result.add(gymMember);
            }//while
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }
        
        
        return result;
    }//end of List<GymMember> read()

    public static final String SQL_INSERT = 
            "insert into GYM_MEMBER (NAME, PHONE, GENDER, BIRTHDAY, ADDRESS) values(?,?,?,?,?)";
    
    public int create(GymMember gymMember) {
        int result = 0;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = conn.prepareStatement(SQL_INSERT);
            
            stmt.setString(1, gymMember.getName());
            stmt.setString(2, gymMember.getPhone());
            stmt.setString(3, gymMember.getGender());
            stmt.setDate(4, gymMember.getBirthday());
            stmt.setString(5, gymMember.getAddress());
            result = stmt.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt);
        }
        return result;
    }//end of create
    

}//end of class
