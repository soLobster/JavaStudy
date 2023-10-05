package com.itwill.list03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListMain03 {

    public static void main(String[] args) {
        List<String> names =  Arrays.asList("java","sql","html","css","javaScript","servlet","jsp","spring");
        //1.names에서 다섯 글자 이상인 문자열을 대문자로 변환해서 저장하는 ArrayList를 만들고 출력.
        ArrayList<String> fiveNames = new ArrayList<String>();
        for(String x : names) {
            if(x.length()>5) {
                fiveNames.add(x.toUpperCase());
            }
        }
        System.out.println(fiveNames);

        System.out.println();
        //2.names에 저장된 문자열의 글자수들을 저장하는 ArrayList를 만들고 출력.
        ArrayList<Integer> numOfNames = new ArrayList<Integer>();
        for(int i = 0; i<names.size();i++) {
            numOfNames.add(names.get(i).length());
        }
        System.out.println(numOfNames);
    
    }//end of main

}//end of class
