package com.itwill.gym.controller;


import com.itwill.gym.model.GymTrainer;

import oracle.jdbc.OracleDriver;

import static com.itwill.gym.GymJdbc.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//MVC 아키텍처 -> Controller
//DB CRUD (Create, Read, Update, Delete).


public class GymTrainerDao {

    //singleton
    private static GymTrainerDao instance = null;

    private GymTrainerDao() {
        // 오라클 데이터베이스를 접속할 수 있는 드라이버(라이브러리)를 등록.
        try {
            DriverManager.registerDriver(new OracleDriver());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }//GymTrainerDao().

    public static GymTrainerDao getInstance() {
        if(instance == null) {
            instance = new GymTrainerDao();
        }
        return instance;
    }//end singleton

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

    private GymTrainer makeGymTrainerResultSet(ResultSet rs) throws SQLException {
        int t_Id = rs.getInt("T_ID");
        String t_name = rs.getString("T_NAME");
        String t_phone = rs.getString("T_PHONE");
        String t_gender = rs.getString("T_GENDER");
        String t_email = rs.getString("T_EMAIL");
        int t_salary = rs.getInt("T_SALARY");
        Date t_birthday = rs.getDate("T_BIRTHDAY");
        Date t_hiredate = rs.getDate("T_HIREDATE");
        String t_address = rs.getString("T_ADDRESS");

        GymTrainer gymTrainer = new GymTrainer
                (t_Id, t_name, t_phone, t_gender, t_email, t_salary, t_birthday, t_hiredate, t_address);

        return gymTrainer;
    }

    //SQL_SELECT_ORDER_BY_ID
    public static final String SQL_SELECT_ORDER_BY_ID = 
            "select * from GYM_TRAINER order by T_ID desc";

    public List<GymTrainer> read() {
        List<GymTrainer> result = new ArrayList<GymTrainer>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = conn.prepareStatement(SQL_SELECT_ORDER_BY_ID);
            rs = stmt.executeQuery();

            while(rs.next()) {
                GymTrainer gymTrainer = makeGymTrainerResultSet(rs);
                result.add(gymTrainer);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }

        return result;
    }//end read().

    //SQL_INSERT
    public static final String SQL_INSERT = 
            "insert into GYM_TRAINER values(?,?,?,?,?,?,?,?,?)";

    public int create(GymTrainer gymTrainer) {
        int result = 0;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = conn.prepareStatement(SQL_INSERT);
            
            stmt.setInt(1, gymTrainer.getT_id());
            stmt.setString(2, gymTrainer.getT_name());
            stmt.setString(3, gymTrainer.getT_phone());
            stmt.setString(4, gymTrainer.getT_gender());
            stmt.setString(5, gymTrainer.getT_email());
            stmt.setInt(6, gymTrainer.getT_salary());
            stmt.setDate(7, gymTrainer.getBirthday());
            stmt.setDate(8, gymTrainer.getHiredate());
            stmt.setString(9, gymTrainer.getT_address());
            
            result = stmt.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt);
        }
        
        return result;
    }// end create().

    
    //SQL_DELETE_BY_ID.
    public static final String SQL_DELETE_BY_ID = 
            "delete from GYM_TRAINER where t_id = ?";
    
    public int delete(Integer t_id) {
        int result = 0;
        
        Connection conn = null;
        PreparedStatement stmt = null; 
        
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = conn.prepareStatement(SQL_DELETE_BY_ID);
            stmt.setInt(1, t_id);
            
            result = stmt.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return result;
    }//end delete method().
    
    public static final String SQL_SELECT_BY_ID = "select * from GYM_TRAINER where t_id = ?";
    
    public GymTrainer read(Integer t_id) {
        GymTrainer trainer = null;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, t_id);
            
            rs = stmt.executeQuery();
            
            if(rs.next()) {
                trainer = makeGymTrainerResultSet(rs);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }
        
        return trainer;
    }//end GymTrianer read(Integer t_id)
    
}//end class
