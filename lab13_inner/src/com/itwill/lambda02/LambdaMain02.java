package com.itwill.lambda02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaMain02 {


    public List<Object> filter(List<Object> list, MyFilter filter) {
        List<Object> result = new ArrayList<Object>();
        for(Object x : list) {
            if(filter.test(x)) {
                result.add(x);
            }//if
        }//for
        return result;
    }//filter method


    public static void main(String[] args) {
        // LambdaMain02 타입 객체 생성
        LambdaMain02 app = new LambdaMain02();

        List<Object> numbers = Arrays.asList(1,2,3,4,5,6,7);
        System.out.println(numbers);

        // numbers의 원소들 중에서 짝수들로만 이루어진 리스트를 만들고 출력.
        List<Object> evens = app.filter(numbers, new MyFilter() {
            @Override
            public boolean test(Object x) { //MyFilter(FunctionalInterface) - abstract method - Override
                return(Integer) x % 2 == 0;
            }
        });

        System.out.println(evens);

        // numbers의 원소들 중에서 홀수들로만 이루어진 리스트를 만들고 출력.
        // 람다 표현식을 사용.

        List<Object> odds = app.filter(numbers, x -> (Integer) x % 2 == 1);
        System.out.println(odds);
        
        List<Object> languages = Arrays.asList("Java","SQL","JavaScript","HTML","Servlet");
        System.out.println(languages);
        
        //languages의 원소들 중에서 5글자 이상인 문자열들로 이루어진 리스트를 만들고 출력.
        List<Object> fiveString = app.filter(languages, new MyFilter() {
            
            @Override
            public boolean test(Object x) {
               return ((String) x).length() >= 5 ; //((String) x)에서 괄호를 꼭 써야한다.
            }
        });
        
        System.out.println(fiveString);
    }

}
