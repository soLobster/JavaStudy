package com.itwill.set02;

import java.util.HashSet;

public class SetMain02 {

    public static void main(String[] args) {
        // HashSet<E> 문자열을 저장, 객체 생성.
        HashSet<String> set = new HashSet<String>();
        set.add("hello");
        System.out.println(set);
        
        set.add("apple");
        System.out.println(set);
        
        set.add("zip");
        System.out.println(set);
        
        for(String s : set) {
            System.out.println(s);
        }

    }

}
