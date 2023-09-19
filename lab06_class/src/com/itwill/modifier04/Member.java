package com.itwill.modifier04;
//회원.....
public class Member {
    
    private String memberId; //읽기전용
    private String memberPwd; //읽/쓰 가능.
    //필드....
    
    public Member(String memberId, String memberPwd) {
        this.memberId = memberId;
        this.memberPwd = memberPwd;
    }
    
    
    //getter /setter 
    public String getMemberId() {
        return this.memberId;
    }
    
    public String getMemeberPwd() {
        return this.memberPwd;
    }
    
    public void setMemberPwd(String memberPwd) {
        this.memberPwd = memberPwd;
    }
}
