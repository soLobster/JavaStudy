package com.itwill.inheritance06;

public class User {
    //field
    private String id;
    private String pwd;

    //ToDo
    //생성자 기본생성자 + 아규먼트 2개짜리 생성자

    public User() {}

    public User(String id, String pwd) {
        this.id = id;
        this.pwd =pwd;
    } //fin....

    //ToDo = toString 재정의...
    @Override
    public String toString() {
        return "User [Id : "+this.id+" / Password : "+this.pwd+"]";
    }

    //ToDo = equals 재정의...- Id만 일치하면 같은 객채.
    //일치 true / false.

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if(obj instanceof User) {
            User usr = (User) obj; //강제 타입변환...(casting)
            if(this.id != null) { //String에 null값.......! null이 아닌 경우에만 메서드 호출 가능...
                result = (this.id.equals(usr.id)); //String 비교 할 때 equals메서드 사용...!
            }
        }
        return result;
    }


    //ToDo hashCode 재정의...String 해쉬코드 재정의....가 제일 쉬울거임
    @Override
    public int hashCode() {
        if(this.id != null) {
            return this.id.hashCode();
        } else {
            return 0;
        }
    }
}
