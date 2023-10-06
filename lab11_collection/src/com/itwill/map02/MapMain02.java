package com.itwill.map02;

import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MapMain02 {

    public static void main(String[] args) {
        // 문자열을 키로 하고, 정수를 값으로 하는 TreeMap을 선언, 생성.
        TreeMap<String, Integer> menu = new TreeMap<>();

        //데이터 저장
        menu.put("짜장면", 8000);
        menu.put("짬뽕", 9000);
        menu.put("볶음밥", 9000);

        System.out.println(menu); //가나다라 순으로 정렬됨.

        System.out.println("-----");

        Set<String> kSet = menu.keySet(); //TreeMap에서는 오름차순 정렬된 키들의 집합.
        for(String k : kSet) {
            System.out.println(k+" : "+menu.get(k));
        }

       
        
        System.out.println("-----"); // 내림차순 집합.
        Set<String> kSet2 = menu.descendingKeySet();
        for(String k : kSet2) {
            System.out.println(k+" : "+menu.get(k));
        }
    }

}
