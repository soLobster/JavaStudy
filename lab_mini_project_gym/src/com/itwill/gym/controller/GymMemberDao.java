package com.itwill.gym.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import com.itwill.gym.model.GymMember;

import oracle.jdbc.OracleDriver;

import static com.itwill.gym.GymJdbc.*;

//MVC 아키텍처 -> Controller
//DB CRUD (Create, Read, Update, Delete).

public class GymMemberDao {
    //singelton
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

    // 회원의 전체 컬럼을 가져오는 역할(결과 처리) -> 편의성을 위해 메서드를 만들었다.
    private GymMember makeGymMemberResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("ID");
        String name = rs.getString("NAME");
        String phone = rs.getString("PHONE");
        String gender = rs.getString("GENDER");
        Date birthday = rs.getDate("BIRTHDAY");
        String address = rs.getString("ADDRESS");
        int membership_code = rs.getInt("MEMBERSHIP_CODE");
        LocalDateTime join_time = rs.getTimestamp("JOIN_TIME").toLocalDateTime();
        LocalDateTime expire_date = rs.getTimestamp("EXPIRE_DATE").toLocalDateTime();
        LocalDateTime buy_membership_date = rs.getTimestamp("BUY_MEMBERSHIP_DATE").toLocalDateTime();
        int pt_code = rs.getInt("PT_CODE");

        //GymMember gymMember = new GymMember(id, name, phone, gender, birthday, address, join_time, expire_date, membership_code, pt_code);
        GymMember gymMember = new GymMember(id, name, phone, gender, birthday, address, join_time, expire_date, buy_membership_date, membership_code, pt_code);
        return gymMember;
    }

    //SQL_SELECT_ORDER_BY_ID
    public static final String SQL_SELECT_ORDER_BY_ID = 
            "select * from GYM_MEMBER order by ID desc";

    /**
     * 데이터베이스 GYM_MEMBER 테이블에서 모든 레코드(행)을 검색해서 리스트를 리턴.
     * 검색 결과는 회원 ID(Sequence)의 내림차순으로 정렬.
     * 테이블에 레코드가 1개도 없는 경우 빈 리스트를 리턴한다.
     * 관리자 계정에서 전체 회원을 불러올때 사용하는 메서드.
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

    /**
     * 데이터 베이스의 GYM_MEMBER 테이블에 행을 삽입(Insert). SQL_INSERT를 실행.
     * GymNewMemberJoin -> createNewMemberJoin
     * @param gymMember GymMemeber 테이블에 insert할 값(name, phone, gender, birthday, address)을 저장한 객체.
     * @return 테이블에 Insert 된 행의 개수.
     */
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

    //    public static String SQL_INSERT_MEMBERSHIPCODE = 
    //            "insert into GYM_MEMBER (NAME, PHONE, GENDER, BIRTHDAY, ADDRESS, MEMBERSHIP_CODE) values(?,?,?,?,?,?)";

    // public int create()

    public static final String SQL_DELETE_BY_ID = 
            "delete from GYM_MEMBER where id = ?";

    /**
     * 데이터 베이스 GYM_MEMBER 테이블에서 글 번호(id)에 해당하는 레코드를 삭제.
     * SQL_DELETE_BY_ID 문장을 실행. 삭제된 행의 개수를 리턴한다.
     * @param id 삭제하려는 회원 번호(id). 테이블의 PK(Primary Key)
     * @return 삭제성공이면 1, 실패시 0.
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

    public static final String SQL_SELECT_BY_ID = "select * from GYM_MEMBER where id = ?";
    /**
     * GYM_MEMBER DB의 회원의 아이디를 검색 결과를 리턴
     * GymShowDetailMember
     * SQL_SELECT_BY_ID 문장을 실
     */
    public GymMember read(Integer id) {
        GymMember gymMembers = null;

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);

            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            if(rs.next()) {
                gymMembers = makeGymMemberResultSet(rs);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }

        return gymMembers;
    }//end GymMember read(integer t_id)


    public static final String SQL_SELECT_BY_PHONE = 
            "select * from GYM_MEMBER where phone = ?";
    /**
     * GYM_MEMBER DB 테이블의 회원의 폰 번호를 검색 결과를 리턴.
     * SQL_SELECT_BY_PHONE 문을 실행
     * @param phone
     * @return
     */
    public GymMember read(String phone) {
        GymMember member = null;

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            stmt = conn.prepareStatement(SQL_SELECT_BY_PHONE);
            stmt.setString(1, phone);

            rs = stmt.executeQuery();

            if(rs.next()) {
                member = makeGymMemberResultSet(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }
        return member;

    }//end read(String phone)

    public static final String SQL_UPDATE_SET_MEMBERSHIP_CODE = 
            "UPDATE GYM_MEMBER SET MEMBERSHIP_CODE=? WHERE ID=?";
    /**
     * BuyMembershipPage의 confirmedBuyMembership()를 실행하기 위한 메서드
     * 
     * @param member
     * @return
     */
    public int updateMembership_Code(GymMember member) {
        int result = 0;

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = conn.prepareStatement(SQL_UPDATE_SET_MEMBERSHIP_CODE);


            stmt.setInt(1, member.getMembership_code()); // Update membership_code
            stmt.setInt(2, member.getId()); // Assuming ID is the primary key

            result = stmt.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt);
        }

        return result;
    }//updateMembership_Code(GymMember member)

    public static final String SQL_UPDATE_SET_PT_CODE = 
            "UPDATE GYM_MEMBER SET PT_CODE = ? WHERE ID = ?";
    public int updatePt_Code(GymMember member) {
        int result = 0;

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            stmt = conn.prepareStatement(SQL_UPDATE_SET_PT_CODE);

            stmt.setInt(1, member.getPt_Code());
            stmt.setInt(2, member.getId());

            result = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt);
        }

        return result;
    } //updatePt_Code(GymMember member)



    public static final String SQL_JOIN_GYM_MEMBER_ON_MEMBERSHIP = 
            "SELECT GYM_MEMBER.*, MEMBERSHIP.MEMBERSHIP_CATEGORY FROM GYM_MEMBER " 
                    +"LEFT JOIN MEMBERSHIP ON GYM_MEMBER.MEMBERSHIP_CODE = MEMBERSHIP.MEMBERSHIP_CODE " 
                    +"ORDER BY ID DESC";

    //    public List<GymMember> readWithMembershipInfo() {
    //        List<GymMember> result = new ArrayList<GymMember>();
    //
    //        Connection conn = null;
    //        PreparedStatement stmt = null;
    //        ResultSet rs = null;
    //        
    //        try {
    //            conn = DriverManager.getConnection(URL, USER, PASSWORD);
    //            stmt = conn.prepareStatement(SQL_JOIN_GYM_MEMBER_ON_MEMBERSHIP);
    //            rs = stmt.executeQuery();
    //            
    //            while(rs.next()) {
    //                GymMember gymMember = makeGymMemberResultSet(rs);
    //                result.add(gymMember);
    //            }
    //            
    //        } catch (Exception e) {
    //            e.printStackTrace();
    //        } finally {
    //            closeResources(conn, stmt, rs);
    //        }
    //        
    //        return result;
    //    }//end of readWithMembershipInfo

    public static final String SELECT_MEMBERSHIP_CATEGORY_FROM_MEMBERSHIP = 
            "SELECT MEMBERSHIP_CATEGORY FROM MEMBERSHIP WHERE MEMBERSHIP_CODE = ?";
    /**
     * MemberInfo에서 initPersonDetails()의 membership_code를 불러와 조인한 다음 membership_category로 변환하기 위한 메서드.
     * 
     * @param membership_code
     * @return
     */
    public String getMembership_category(int membership_code) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String membership_category = null;

        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = conn.prepareStatement(SELECT_MEMBERSHIP_CATEGORY_FROM_MEMBERSHIP);
            stmt.setInt(1, membership_code);
            rs = stmt.executeQuery();

            if (rs.next()) {
                membership_category = rs.getString("MEMBERSHIP_CATEGORY");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }

        return membership_category;
    }//end getMembership_category

    public static final String SELECT_MEMBERSHIP_NUMOFDAYS_FROM_MEMBERSHIP = 
            "select membership_numofdays from membership where membership_code = ?";

    public int getMembershipNumOfDays(int membership_code) {
        int days = 0;

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = conn.prepareStatement(SELECT_MEMBERSHIP_NUMOFDAYS_FROM_MEMBERSHIP);
            stmt.setInt(1, membership_code);

            rs = stmt.executeQuery();

            if(rs.next()) {
                days = rs.getInt("MEMBERSHIP_NUMOFDAYS");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);   
        }

        return days;
    }//end of getMembershipnumofdays

    public static final String UPDATE_GYM_MEMBER_SET_EXPIRE_DATE = 
            "update gym_member set expire_date = ? where id = ?";

    public int updateGymMemberSetExpireDate(int id, LocalDateTime expireDate) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection(URL,USER, PASSWORD);
            stmt = conn.prepareStatement(UPDATE_GYM_MEMBER_SET_EXPIRE_DATE);
            stmt.setTimestamp(1, Timestamp.valueOf(expireDate));
            stmt.setInt(2, id);

            return stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            closeResources(conn, stmt);
        }

    }//end updateGymMemberSetExpireDate
    
    public static final String UPDATE_GYM_MEMBER_SET_BUY_MEMBERSHIP_DATE = 
            "update gym_member set buy_membership_date = ? where id = ?";
    
    public int updateBuyMembershipDate(int id, LocalDateTime buyMembershipDate) {
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = conn.prepareCall(UPDATE_GYM_MEMBER_SET_BUY_MEMBERSHIP_DATE);
            stmt.setTimestamp(1, Timestamp.valueOf(buyMembershipDate));
            stmt.setInt(2, id);
            
            return stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            closeResources(conn, stmt);
        }
    }
    
    

    public static final String SQL_UPDATE_GYM_MEMBER = 
            "update gym_member set name = ?, phone = ?, address = ?, gender = ?, birthday = ? where id = ?";

    public int update(GymMember gymMember) {
        int result = 0;

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt =conn.prepareStatement(SQL_UPDATE_GYM_MEMBER);
            stmt.setString(1, gymMember.getName());
            stmt.setString(2, gymMember.getPhone());
            stmt.setString(3, gymMember.getAddress());
            stmt.setString(4, gymMember.getGender());
            stmt.setDate(5, gymMember.getBirthday());
            stmt.setInt(6, gymMember.getId());

            result = stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt);
        }

        return result;
    }

    //이름에 검색 키워드가 포함된 모든 결과를 검색.(대소 구분 없이)
    public static final String SQL_SELECT_BY_NAME = 
            "select * from gym_member where lower(name) like ? order by id desc";
    // 연락처로 검색 키워드가 포함된 모든 결과를 검색.
    public static final String SQL_SELECT_BY_MEMBER_PHONENUM = 
            "select * from gym_member where lower(phone) like ? order by id desc";
    // 성별 검색 키워드가 포함된 모든 결과를 검색.
    public static final String SQL_SELECT_BY_GENDER = 
            "select * from gym_member where lower(gender) like ? order by id desc";
    // 생일 검색 키워드.
    public static final String SQL_SELECT_BY_BIRTHDAY = 
            "select * from gym_member where TO_CHAR(birthday, 'YYYY-MM-DD') like ? order by birthday desc";
   

    public List<GymMember> search(int type, String keyword) {
        final String searchKeyword = "%" + keyword.toLowerCase() + "%";
        List<GymMember> result = new ArrayList<GymMember>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            switch(type) {
            case 0:
                stmt = conn.prepareStatement(SQL_SELECT_BY_NAME);
                stmt.setString(1, searchKeyword);
                break;
            case 1:
                stmt = conn.prepareStatement(SQL_SELECT_BY_MEMBER_PHONENUM);
                stmt.setString(1, searchKeyword);
                break;
            case 2:
                stmt = conn.prepareStatement(SQL_SELECT_BY_GENDER);
                stmt.setString(1, searchKeyword);
                break;
            case 3:
                stmt = conn.prepareStatement(SQL_SELECT_BY_BIRTHDAY);
                stmt.setString(1, searchKeyword);
                break;
            }

            rs = stmt.executeQuery();

            while(rs.next()) {
                GymMember g = makeGymMemberResultSet(rs);
                result.add(g);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }


        return result;
    }


}//end of class
