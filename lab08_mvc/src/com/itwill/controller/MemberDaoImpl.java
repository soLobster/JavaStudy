package com.itwill.controller;

import com.itwill.model.Member;

//MVC 아키텍쳐에서 Controller 역할 담당 클래스 - data access object (DAO)
public class MemberDaoImpl implements MemberDao{

    //singleton 
    //1) private static field. 
    //2) private constructor.
    //3) public static method.
    private static MemberDaoImpl instance = null; // singleton 1)

    private MemberDaoImpl() {} // singleton 2)

    public static MemberDaoImpl getInstance() { // singleton 3)
        if(instance == null) { // MemberDaoImpl 타입 객체가 생성되어 있지 않은 경우
            instance = new MemberDaoImpl(); // MemberDaoImpl 타입 객체 생성.
        }
        return instance;
    }
    
    public static final int MAX_LENGTH = 2; // 배열 최대 길이(원소 개수)
    
    private Member[] members = new Member[MAX_LENGTH]; // 회원 정보 배열.
    
    private int count = 0; // private으로 카운트 선언...!
    
    public int getCount() { // public으로 count getter...!  -> setter는 제공하지 않는다...
        return count;       // 값을 변경할 수 없다 -> 이것이 데이터의 캡슐화..
    }

    @Override
    public Member[] read() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int create(Member member) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Member read(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int update(int index, String pwd) {
        // TODO Auto-generated method stub
        return 0;
    }

}
