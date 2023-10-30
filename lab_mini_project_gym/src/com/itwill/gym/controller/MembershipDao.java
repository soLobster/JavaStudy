package com.itwill.gym.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.itwill.gym.GymJdbc.*;
import com.itwill.gym.model.Membership;

import oracle.jdbc.OracleDriver;

//MVC 아키텍처 -> Controller 
//DB CRUD

public class MembershipDao {
    //singleton
    private static MembershipDao instance = null;

    private MembershipDao() {
        //오라클 DB에 접속할 수 있는 드라이버를 등록.
        try {
            DriverManager.registerDriver(new OracleDriver());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//MembershipDao

    public static MembershipDao getInstance() {
        if(instance == null) {
            instance = new MembershipDao();
        }
        return instance;
    }//static MembershipDao getInstance() -> end singleton.

    //리소스 해제.
    private void closeResources(Connection conn, Statement stmt) {
        try {
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void closeResources(Connection conn, Statement stmt, ResultSet rs) {
        try {
            rs.close();
            closeResources(conn, stmt);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


    private Membership makeMembershipResultSet(ResultSet rs) throws SQLException {
        int membershipCode = rs.getInt("MEMBERSHIPCODE");
        int membershiplength = rs.getInt("MEMBERSHIPLENGTH");
        int membershipprice = rs.getInt("MEMBERSHIPPRICE");
        String membershipcategory = rs.getString("MEMBERSHIPCATEGORY");

        Membership membership = new Membership(membershipCode, membershiplength, membershipprice, membershipcategory);

        return membership;
    }//makeMembershipResult()

    //SQL_SELECT_ORDER_BY_MEMBERSHIPCODE
    public static final String SQL_SELECT_ORDER_BY_MEMBERSHIPCODE = 
            "select * from MEMBERSHIP order by MEMBERSHIPCODE desc";

    public List<Membership> read(){
        List<Membership> result = new ArrayList<Membership>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = conn.prepareStatement(SQL_SELECT_ORDER_BY_MEMBERSHIPCODE);
            rs = stmt.executeQuery();

            while(rs.next()) {
                Membership membership = makeMembershipResultSet(rs);
                result.add(membership);
            }//while

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }
        return result;
    }//end of List<Membership> read().

    public static final String SQL_SELECT_MEMBERSHIPCODE  = 
            "select MEMBERSHIPCODE from MEMBERSHIP where MEMBERSHIPCODE = ?";

    public Membership read(Integer memCode){
        Membership membership = null;

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            stmt = conn.prepareStatement(SQL_SELECT_MEMBERSHIPCODE);
            stmt.setInt(1, memCode);
         
            rs = stmt.executeQuery();
            
            if(rs.next()){
                membership = makeMembershipResultSet(rs);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }
        return membership;

    }//end read(Integer memCode)


    public int selectMembershipCode(String s) {
        // TODO
        return 0;
    }

}//end of class


