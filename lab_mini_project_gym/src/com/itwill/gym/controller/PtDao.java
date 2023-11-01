package com.itwill.gym.controller;

import static com.itwill.gym.GymJdbc.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.itwill.gym.model.PT;
import com.itwill.gym.model.PtWithTrainer;

import oracle.jdbc.OracleDriver;

//MVC 아키텍처 -> Controller 
//DB CRUD

public class PtDao {
    //singleton
    private static PtDao instance = null;

    private PtDao() {
        //오라클 DB에 접속할 수 있는 드라이버를 등록.
        try {
            DriverManager.registerDriver(new OracleDriver());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }//ptDao()

    public static PtDao getInstance() {
        if(instance == null) {
            instance = new PtDao();
        }
        return instance;
    }//end singleton

    //리소스 해제 
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
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private PT makePtResultSet(ResultSet rs) throws SQLException {
        Integer pt_code = rs.getInt("PT_CODE");
        Integer t_id = rs.getInt("T_ID");
        Integer pt_price = rs.getInt("PT_PRICE");
        Integer pt_time = rs.getInt("PT_TIME");
        String pt_category = rs.getString("PT_CATEGORY");

        PT pt = new PT(pt_code, t_id, pt_price, pt_time, pt_category);
        return pt;
    }//makePtResultSet(rs)




    //SQL_SELECT_ORDER_BY_PT_CODE
    public static final String SQL_SELECT_ORDER_BY_PT_CODE = 
            "select * from PT order by PT_CODE desc";

    public List<PT> read() {
        List<PT> list = new ArrayList<PT>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = conn.prepareStatement(SQL_SELECT_ORDER_BY_PT_CODE);
            rs = stmt.executeQuery();

            while(rs.next()) {
                PT pt = makePtResultSet(rs);
                list.add(pt);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }
        return list;
    }//end List<> read()


    //SQL GYM_TRAINER 테이블과 PT 테이블 JOIN.
    public static final String SQL_GYM_TRAINER_JOIN_PT = 
            "select g.t_id, g.t_name, p.pt_code, p.pt_price, p.pt_time, p.pt_category "
            + "from gym_trainer g "
            + "join pt p "
            + "on g.t_id = p.t_id";

    public List<PtWithTrainer> readJoin() {
        List<PtWithTrainer> JoinList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            stmt = conn.prepareStatement(SQL_GYM_TRAINER_JOIN_PT);
            rs = stmt.executeQuery();

            // SQL 실행 및 결과를 PtWithTrainer 객체로 매핑하여 list에 추가
            while(rs.next()) {
                PtWithTrainer pwt = new PtWithTrainer();
                pwt.setT_id(rs.getInt("T_ID"));
                pwt.setTrainerName(rs.getString("T_NAME"));
                pwt.setPt_code(rs.getInt("PT_CODE"));
                pwt.setPt_price(rs.getInt("PT_PRICE"));
                pwt.setPt_time(rs.getInt("PT_TIME"));
                pwt.setPt_category(rs.getString("PT_CATEGORY"));
                JoinList.add(pwt);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }


        return JoinList;
    }


}//end class
