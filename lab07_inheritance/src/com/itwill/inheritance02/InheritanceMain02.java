package com.itwill.inheritance02;

public class InheritanceMain02 {

    public static void main(String[] args) {
        //Person 타입 객체를 생성.....기본 생성자를 사용해서 생성....
        
        Person p1 = new Person();
        System.out.println("p1 이름 >> "+p1.getName()); //private으로 감춰진 name을 getter 메서드로 가져온다...

        System.out.println("--super--");
        
        //Person 타입 객체를 아규먼트를 갖는 생성자를 사용해서 생성....
        Person p2 = new Person("LeBron James");
        System.out.println("p2 이름 >> "+p2.getName());
        
        
        System.out.println("==inheritance==");
        System.out.println("====s1=====");
        Student s1 = new Student(); //객체가 연속된 공간에 저장된다...(메모리)....
        System.out.println("s1 이름 >> "+s1.getName()); //superclass Person에서 상속받은 getter...
        System.out.println("s1 학교 >> "+s1.getSchoolName()); //subclass Student에서 작성한 getter...
        
//        s1.setName("Lebron James Jr");
//        s1.setSchoolName("LA Lakers");
//        System.out.println("======");
//        System.out.println("s1 이름 >> "+s1.getName());
//        System.out.println("s1 학교 >> "+s1.getSchoolName());
//        
        System.out.println("====s2=====");
        
        Student s2 = new Student("denver Nuggets");
        System.out.println("s2 이름 >> "+s2.getName());
        System.out.println("s2 학교 >> "+s2.getSchoolName());
        System.out.println("====s3=====");
        Student s3 = new Student("Curry", "Golden State Warriors");
        System.out.println("s3 이름 >> "+s3.getName());
        System.out.println("s3 학교 >> "+s3.getSchoolName());
    }

}
