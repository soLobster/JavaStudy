package com.itwill.singleton;

/**
 * 싱글톤 singleton 오직 한번만 생성할 수 있는 객체.
 * 
 */


public class SingletonMain {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        Captain captain1 = Captain.getInstance();
        //new를 통해 새롭게 인스턴스화 하는 것이 아닌
        /**
         * Captain.getInstace를 통해서 기존의 Captain을 사용..
         * 
         */
        
        System.out.println("captain1 >> "+captain1);
        
        System.out.println(captain1.getName());
        captain1.setName("아이언맨");
        System.out.println(captain1.getName());
        
        Captain captain2 = Captain.getInstance();
        
        System.out.println("captain2 >> "+captain2);
        captain2.setName("토르");
        
        System.out.println(captain1.getName());
        System.out.println(captain2.getName());
    }

}
