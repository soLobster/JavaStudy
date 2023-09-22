package com.itwill.inheritance02;

//Student - subclass, Person - superclass....

public class Student extends Person {
    //필드 확장...
    private String schoolName;

    
    /*
     * 생성자
     * 상위(부모) 타입의 객체가 먼저 생성되어 있어야 하위(자식) 타입 객체도 생성될 수 있음.
     * 생성자 호출 순서 -> 상위 클래스 생성자 -> 하위 클래스 생성자 호출
     * 하위 클래스 생성자에서 상위 클래스 생성자를 명시적으로 호출하지 않으면..
     * 상위 클래스의 기본 생성자가 자동으로 호출됨..
     * 하위 클래스 생성자에서 명시적으로 상위 클래스 생성자를 호출하려면 super() 키워드를 사용.
     * 상위 클래스의 아규먼트(들)을 갖는 생성자는 자동으로 호출되지 않음.
     * 상위 클래스의 아규먼트(들)을 갖는 생성자를 이용하려면 명시적으로 super(...)를 호출해야 함...
     * super(...) 호출은 생성자 안에서 가장 먼저 작성되어야 함.
     * 
     * this의 의미
     * 1) 생성된 객체 주소(참조값) >> this.field, this.method()
     * 2) overloading 된 생성자를 의미 >> this(), this(arg) -> 자기 클래스에서 만들어진 다른 생성자들을 호출할 때 사용한다.
     * 
     * 
     * 
     * super의 의미
     * 1) 생성된 부모 타입 객체 주소(참조값) >> super.field, super.method() 부모를 찾아간다. 부모가 공개한 필드, 메서드.
     * 2) 상위 클래스의 생성자: super(), super(arg)..부모의 생성자를 호출.
     */
    
    //생성자 생성...고민 곰곰...
    public Student() {
        super(); //상위 클래스의 "기본 생성자" 명시적 호출....
        //super의 호출은 생성자 안에서 가장 먼저 작성되어야한다의 사례.
        //부모 먼저 만들고 자식이 와야한다.
        
        System.out.println("Student() 호출");
        //super(); 컴파일 오류 난다.
    } //기본 생성자....
    //heap에 null 타입으로 초기화가 된다..
    //name.....schoolname.....
    
    //1) 아규먼트 1개 (학교이름)를 갖는 생성자...
    public Student(String schoolName) {
        super();//생략 가능 (omit).
        this.schoolName = schoolName;
    }//아규먼트를 갖는 생성자 생성.....!

    //2) 아규먼트 2개를 갖는 생성자....
    public Student(String name, String schoolName) {
        super(name); // 상위 클래스의 아규먼트를 갖는 생성자를 명시적으로 호출...
        //private는 상속을 해줘도 보이지 않는다...
        this.schoolName = schoolName;
        System.out.println("Student(name,schoolName) 생성자 호출");
        //super(name) super의 호출이 무조건 첫번째로 가야한다....컴파일 에러남.
    }
    
    //getter, setter.
    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

}
