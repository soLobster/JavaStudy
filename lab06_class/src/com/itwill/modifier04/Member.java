package com.itwill.modifier04;
//회원.....
public class Member {
    
    //private 타입 캡슐화.....
    private String memberId; //읽기전용
    private String memberPwd; //읽/쓰 가능.
    //필드....
    
    public Member(String memberId, String memberPwd) {
        this.memberId = memberId;
        this.memberPwd = memberPwd;
    }//Member 생성자.....
    
    
    //getter /setter 
    public String getMemberId() {
        return this.memberId;
    } //getter.....
    
    public String getMemeberPwd() {
        return this.memberPwd;
    } //getter.....
    
    public void setMemberPwd(String memberPwd) {
        this.memberPwd = memberPwd;
    }//setter.....
}
