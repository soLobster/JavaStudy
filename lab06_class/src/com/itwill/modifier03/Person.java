package com.itwill.modifier03;

public class Person {
    //지금부터는 필드 선언시 private를 붙인다..
    private String name; //읽기(get) 전용 데이터....
    private int age; //읽기, 쓰기(set) 가능 데이터....

    //생성자...
    public Person(String name, int age) {
        this.name = name;
        //무결성 유지
        if(age >=0 ) {
            this.age = age;
        } else {
            this.age = 0;
        }
        //this.age = age; age가 음수가 될 수도 있다....
    }

    //메서드는 특별한 경우가 아니면 public으로 한다...

    public String getName() { //getter 메서드....
        return this.name;
    }

    public int getAge() {  //getter 메서드....
        return this.age;
    }
    
    public void setAge(int age) { //setter 메서드....
                      //int 타입 아규먼트가 필요하다...
        //나이는 0 이상이어야 한다는 무결성을 유지하기 위해서
        if(age >= 0) {
            this.age = age;
        }
        //age < 0 인 경우에는 값을 변경하지 않는다...
    }
}
