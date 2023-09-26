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

    /**
     * 아규먼트 index가 유효한 범위의 인덱스인 지를 검사.
     * 
     * index >= 0 이고, index가 배열의 저장된 원소 개수(count)보다 작으면 true 
     * 그렇지 않으면 false가 된다.
     * 
     * @param index 유효한지 검사할 인덱스.(int).
     * @return. 유효하면 true 또는 false....
     */
    
    public boolean isValidIndex(int index) {
        return index >=0 && index < count;
    }
    
    
    @Override
    public Member[] read() {
        // TODO Auto-generated method stub
        // members를 그대로 리턴하지 말고, 실제 저장된 원소 개수 크기만큼의 배열만 리턴하자.
        Member[] memberArray = new Member[count];
        for(int i = 0; i < count; i++) {
            memberArray[i] = members[i];
        }
        return memberArray;
    }

    @Override
    public int create(Member member) {
        int result = 0; //실패...
        if(count < MAX_LENGTH) { //배열의 전체 길이보다 카운트가 작다. 연락처 추가 가능하다는 의미.
            members[count] = member;
            count++;
            result = 1;
        }
        return result;
    }

    @Override
    public Member read(int index) {
        if(isValidIndex(index)) {
            return members[index];   
        } else {
            return null;
        }
    }

    @Override
    public int update(int index, String pwd) {
        int result = 0;
        if(isValidIndex(index)) {
            members[index].setPwd(pwd);
            result = 1;
        } 
        return result;
    }

}
