package com.itwill.modifier04;

public class MemberTest {

    public static void main(String[] args) {
        // Member 타입 객체 생성
        // 아이디와 비밀번호 출력.
        // 비밀번호 변경, 확인...
        
        Member user1 = new Member("kooj0526", "0000");
        System.out.println("user1의 아이디 >> "+user1.getMemberId());
        System.out.println("user1의 비밀번호 >> "+user1.getMemeberPwd());
        user1.setMemberPwd("123456789");
        System.out.println("user1의 비밀번호 변경 후 >> "+user1.getMemeberPwd());
    }

}
